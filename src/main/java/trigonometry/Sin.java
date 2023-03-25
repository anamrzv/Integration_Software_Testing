package trigonometry;

import exceptions.AccuracyException;
import exceptions.Calculatable;

import java.math.BigDecimal;
import java.math.MathContext;

import static java.math.MathContext.DECIMAL128;
import static java.math.RoundingMode.HALF_EVEN;

public class Sin implements Calculatable {
    private final Cos cos;

    public Sin() {
        this.cos = new Cos();
    }

    public BigDecimal calculate(double x, double eps) throws AccuracyException, ArithmeticException {
        if (x >= 0) {
            while (x > 2 * Math.PI) {
                x -= 2 * Math.PI;
            }
        } else {
            while (x < 2 * Math.PI) {
                x += 2 * Math.PI;
            }
        }

        final MathContext mc = new MathContext(DECIMAL128.getPrecision(), HALF_EVEN);
        BigDecimal withoutSign = BigDecimal.ONE.subtract(cos.calculate(x, eps).pow(2)).sqrt(mc).abs();
        if (x > Math.PI) return withoutSign.multiply(BigDecimal.valueOf(-1));
        else return withoutSign;
    }
}
