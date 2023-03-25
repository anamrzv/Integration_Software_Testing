package trigonometry;

import exceptions.AccuracyException;
import exceptions.Calculatable;

import java.math.BigDecimal;

import static java.lang.String.format;
import static java.math.RoundingMode.HALF_EVEN;

public class Sec implements Calculatable {
    private final Cos cos;

    public Sec() {
        this.cos = new Cos();
    }

    public BigDecimal calculate(double x, double eps) throws AccuracyException, ArithmeticException {
        BigDecimal calculatedCos = cos.calculate(x, eps);
        if (calculatedCos.compareTo(BigDecimal.ZERO) == 0)
            throw new ArithmeticException(format("Sec value for argument %s doesn't exist", x));
        else return BigDecimal.ONE.divide(calculatedCos, 30, HALF_EVEN);
    }
}
