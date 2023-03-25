import logarithms.Log2;
import logarithms.Log3;
import logarithms.Log5;
import utils.Calculatable;
import logarithms.Ln;
import trigonometry.*;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class FunctionsSystem implements Calculatable {
    private final Cos cos;
    private final Sin sin;
    private final Cot cot;
    private final Tg tg;
    private final Csc csc;
    private final Sec sec;
    private final Ln ln;
    private final Log2 log2;
    private final Log3 log3;
    private final Log5 log5;

    public FunctionsSystem() {
        this.cos = new Cos();
        this.sin = new Sin();
        this.cot = new Cot();
        this.csc = new Csc();
        this.sec = new Sec();
        this.tg = new Tg();

        this.ln = new Ln();
        this.log2 = new Log2();
        this.log3 = new Log3();
        this.log5 = new Log5();
    }

    public FunctionsSystem(Cos cos, Sin sin, Cot cot, Tg tg, Csc csc, Sec sec, Ln ln, Log2 log2, Log3 log3, Log5 log5) {
        this.cos = cos;
        this.sin = sin;
        this.cot = cot;
        this.tg = tg;
        this.csc = csc;
        this.sec = sec;
        this.ln = ln;
        this.log2 = log2;
        this.log3 = log3;
        this.log5 = log5;
    }

    public BigDecimal calculate(double x, double eps) {
        try {
            if (x > 0) {
                return ln.calculate(x, eps)
                        .add(log2.calculate(x, eps))
                        .add(log3.calculate(x, eps))
                        .add(log5.calculate(x, eps))
                        .pow(3)
                        .pow(2);
            } else {
                BigDecimal firstTermNumerator = sec.calculate(x, eps)
                        .multiply(csc.calculate(x, eps))
                        .divide(csc.calculate(x, eps), 30, RoundingMode.HALF_UP);
                BigDecimal firstTermDenominator = cos.calculate(x, eps)
                        .add(sin.calculate(x, eps))
                        .subtract(sec.calculate(x, eps))
                        .divide(cot.calculate(x, eps), 30, RoundingMode.HALF_UP);
                BigDecimal firstMul = firstTermNumerator
                        .divide(firstTermDenominator, 30, RoundingMode.HALF_UP)
                        .add(cot.calculate(x, eps))
                        .divide(tg.calculate(x, eps), 30, RoundingMode.HALF_UP)
                        .pow(3)
                        .add(cos.calculate(x, eps))
                        .subtract(tg.calculate(x, eps)); // до умножения

                BigDecimal secondMul = cot.calculate(x, eps)
                        .multiply(sin.calculate(x, eps).divide(cos.calculate(x, eps).add(cot.calculate(x, eps)), 30, RoundingMode.HALF_UP))
                        .add(sec.calculate(x, eps))
                        .subtract(csc.calculate(x, eps).multiply(csc.calculate(x, eps)).multiply(sin.calculate(x, eps)).pow(3));
                BigDecimal upperPart = firstMul.multiply(secondMul).pow(3);

                BigDecimal lowerFraction = csc.calculate(x, eps)
                        .add(sec.calculate(x, eps).divide(sec.calculate(x, eps).multiply(csc.calculate(x, eps)), 30, RoundingMode.HALF_UP).multiply(cos.calculate(x, eps)))
                        .divide(cos.calculate(x, eps), 30, RoundingMode.HALF_UP);
                BigDecimal rightParenthesis = csc.calculate(x, eps)
                        .subtract(cos.calculate(x, eps)
                                .subtract(sin.calculate(x, eps)
                                        .subtract(sin.calculate(x, eps))
                                        .add(cot.calculate(x, eps))
                                        .pow(2))
                                .add(tg.calculate(x, eps)))
                        .add(csc.calculate(x, eps))
                        .add(cos.calculate(x, eps))
                        .subtract(csc.calculate(x, eps)
                                .divide(sec.calculate(x, eps)
                                        .subtract(sin.calculate(x, eps)), 30, RoundingMode.HALF_UP));

                BigDecimal lowerPart = csc.calculate(x, eps)
                        .subtract(lowerFraction)
                        .subtract(sin.calculate(x, eps))
                        .subtract(cos.calculate(x, eps))
                        .add(rightParenthesis);

                return upperPart.divide(lowerPart, 30, RoundingMode.HALF_UP);
            }
        } catch (ArithmeticException e) {
            return null;
        }
    }
}
