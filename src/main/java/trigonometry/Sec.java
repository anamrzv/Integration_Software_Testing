package trigonometry;

import utils.AccuracyException;
import utils.Calculatable;

import java.math.BigDecimal;

import static java.lang.String.format;
import static java.math.RoundingMode.HALF_EVEN;

public class Sec implements Calculatable {
    private final Cos cos;

    public Sec() { this.cos = new Cos();}

    public Sec(Cos cos) {
        this.cos = cos;
    }

    public BigDecimal calculate(double x, double eps) throws AccuracyException, ArithmeticException {
        BigDecimal calculatedCos = cos.calculate(x, eps);
        if (calculatedCos.compareTo(BigDecimal.ZERO) == 0) return null;
        else return BigDecimal.ONE.divide(calculatedCos, 30, HALF_EVEN);
    }
}
