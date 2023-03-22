import logarithms.Ln;
import logarithms.Log;
import trigonometry.*;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class FunctionsSystem {

    private final Cos cos;
    private final Sin sin;
    private final Cot cot;
    private final Tg tg;
    private final Csc csc;
    private final Sec sec;
    private final Ln ln;
    private final Log log2;
    private final Log log3;
    private final Log log5;

    public FunctionsSystem() {
        this.cos = new Cos();
        this.sin = new Sin();
        this.cot = new Cot();
        this.csc = new Csc();
        this.sec = new Sec();
        this.tg = new Tg();

        this.ln = new Ln();
        this.log2 = new Log(2);
        this.log3 = new Log(3);
        this.log5 = new Log(5);
    }

    public BigDecimal calculate(double x, double eps) {
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
            BigDecimal firstMul = firstTermNumerator.divide(firstTermDenominator, 30, RoundingMode.HALF_UP)
                    .add(cot.calculate(x, eps))
                    .divide(tg.calculate(x, eps), 30, RoundingMode.HALF_UP)
                    .pow(3)
                    .add(cos.calculate(x, eps))
                    .subtract(tg.calculate(x, eps));
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
    }
}
