package trigonometry;

import exceptions.AccuracyException;

import java.math.BigDecimal;

import static java.lang.String.format;
import static java.math.RoundingMode.HALF_EVEN;

public class Csc {
    private final Sin sin;

    public Csc() {
        this.sin = new Sin();
    }

    public BigDecimal calculate(double x, double eps) throws AccuracyException, ArithmeticException {
        BigDecimal calculatedSin = sin.calculate(x, eps);
        if (calculatedSin.compareTo(BigDecimal.ZERO) == 0)
            throw new ArithmeticException(format("Csc value for argument %s doesn't exist", x));
        else return BigDecimal.ONE.divide(calculatedSin, 30, HALF_EVEN);
    }
}
