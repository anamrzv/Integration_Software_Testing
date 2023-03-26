import logarithms.Log2;
import logarithms.Log3;
import logarithms.Log5;
import utils.Calculatable;
import logarithms.Ln;
import trigonometry.*;

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

    public double calculate(double x, double eps) {
        try {
            if (x > 0) {
                return Math.pow(Math.pow((ln.calculate(x, eps) + log2.calculate(x, eps) + log3.calculate(x, eps) + log5.calculate(x, eps)), 3), 2);
            } else {
                double secx = sec.calculate(x, eps);
                double cscx = csc.calculate(x, eps);
                double cosx = cos.calculate(x, eps);
                double sinx = sin.calculate(x, eps);
                double cotx = cot.calculate(x, eps);
                double tgx = tg.calculate(x, eps);

                double term1Numerator1 = secx * cscx;
                double term1Numerator = term1Numerator1 / cscx;

                double term1Denominator1 = cosx + (sinx - secx);
                double term1Denominator = term1Denominator1 / cotx;

                double term1Mul1 = (term1Numerator / term1Denominator) + cotx;
                double term1Mul = Math.pow((term1Mul1 / tgx), 3) + (cosx - tgx);

                double term2Mul1 = cotx * (sinx / (cosx + cotx));
                double term2Mul2 = term2Mul1 + secx;
                double term2Mul3 = Math.pow((cscx * cscx * sinx), 3);
                double term2Mul = term2Mul2 - term2Mul3;

                double upperPart = Math.pow(term1Mul * term2Mul, 3);

                double term3Numerator1 = secx / (secx * cscx);
                double term3Numerator = term3Numerator1 * cosx;
                double term3Denominator1 = cscx + term3Numerator;
                double term3Denominator = term3Denominator1 / cosx;
                double term4 = cscx - term3Denominator - sinx - cosx;

                double lowerPart = term4 + (cscx - ((cosx - Math.pow((sinx - (sinx + cotx)), 2) + tgx) + (cscx + (cosx - (cscx / (secx - sinx))))));

                return upperPart / lowerPart;
//                double a = (sec.calculate(x, eps) * csc.calculate(x, eps)) / csc.calculate(x, eps);
//                double b = (cos.calculate(x, eps) + (sin.calculate(x, eps) - sec.calculate(x, eps))) / cot.calculate(x, eps);
//                double c = (a / b) + cot.calculate(x, eps);
//                double d = Math.pow((c / tg.calculate(x, eps)), 3) + (cos.calculate(x, eps) - tg.calculate(x, eps));
//                double e = (((cot.calculate(x, eps)) * (sin.calculate(x, eps) / (cos.calculate(x, eps) + cot.calculate(x, eps)))) - (Math.pow(((csc.calculate(x, eps) * csc.calculate(x, eps)) * sin.calculate(x, eps)), 3)));
//                double f = Math.pow((d * e), 3);
//
//                double h = (csc.calculate(x, eps) + ((sec.calculate(x, eps) / (sec.calculate(x, eps) * csc.calculate(x, eps))) * cos.calculate(x, eps))) / cos.calculate(x, eps);
//                double g = (((csc.calculate(x, eps)-h)-sin.calculate(x,eps))- cos.calculate(x,eps));
//                double j = g + (csc.calculate(x, eps)-
//                                    ((cos.calculate(x,eps)-
//                                            (( Math.pow((sin.calculate(x,eps)-(sin.calculate(x,eps)+cot.calculate(x,eps))),2)
//                                                    +tg.calculate(x,eps)))
//                                            + (csc.calculate(x,eps)+(cos.calculate(x, eps)- (csc.calculate(x,eps)/(sec.calculate(x,eps)- sin.calculate(x,eps))))))
//                                    )
//                                );
//                double result = f/j;

//                double firstTermNumerator1 = sec.calculate(x, eps) * csc.calculate(x, eps);
//                double firstTermNumerator = firstTermNumerator1 / csc.calculate(x, eps);
//
//                double firstTermDenominator1 = cos.calculate(x, eps) + (sin.calculate(x, eps) - sec.calculate(x, eps));
//                double firstTermDenominator = firstTermDenominator1 / cot.calculate(x, eps);
//
//                double firstMul1 = (firstTermNumerator / firstTermDenominator) + cot.calculate(x, eps);
//
//                double firstMul = Math.pow((firstMul1 / tg.calculate(x, eps)), 3) + (cos.calculate(x, eps) - tg.calculate(x, eps));
//
//                double secondMul1 = cot.calculate(x, eps) * (sin.calculate(x, eps) / (cos.calculate(x, eps) + cot.calculate(x, eps)));
//                double secondMul2 = secondMul1 + sec.calculate(x, eps);
//
//                double rightPart = Math.pow((csc.calculate(x, eps) * csc.calculate(x, eps) * sin.calculate(x, eps)), 3);
//                double secondMul = secondMul2 - rightPart;
//                double upperPart = Math.pow(firstMul * secondMul, 3);
//
//                double lowerFraction = (csc.calculate(x, eps) + ((sec.calculate(x, eps) / (sec.calculate(x, eps) * csc.calculate(x, eps))) * cos.calculate(x, eps))) / cos.calculate(x, eps);
//                double rightParenthesis = csc.calculate(x, eps)
//                        - ((cos.calculate(x, eps)
//                        - (Math.pow((sin.calculate(x, eps)
//                        - (sin.calculate(x, eps)
//                        + cot.calculate(x, eps))), 2)
//                        + tg.calculate(x, eps)))
//                        + (csc.calculate(x, eps)
//                        + (cos.calculate(x, eps)
//                        - (csc.calculate(x, eps)
//                        / (sec.calculate(x, eps)
//                        - sin.calculate(x, eps))))));
//
//                double lowerPart = csc.calculate(x, eps)
//                        - lowerFraction
//                        - sin.calculate(x, eps)
//                        - cos.calculate(x, eps)
//                        + rightParenthesis;
//
//                double result = upperPart / lowerPart;
//                if (Math.abs(result) > 3000) return Double.NaN;
//                else return result;
            }
        } catch (ArithmeticException e) {
            return Double.NaN;
        }
    }
}
