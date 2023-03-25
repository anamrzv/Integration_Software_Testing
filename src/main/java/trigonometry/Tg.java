package trigonometry;

import exceptions.AccuracyException;
import exceptions.Calculatable;

import java.math.BigDecimal;

import static java.lang.String.format;
import static java.math.RoundingMode.HALF_EVEN;

public class Tg implements Calculatable {
    private final Cos cos;
    private final Sin sin;

    public Tg() {
        this.cos = new Cos();
        this.sin = new Sin();
    }

    public BigDecimal calculate(double x, double eps) throws AccuracyException, ArithmeticException {
        BigDecimal calculatedCos = cos.calculate(x, eps);
        if (calculatedCos.compareTo(BigDecimal.ZERO) == 0)
            throw new ArithmeticException(format("Tg value for argument %s doesn't exist", x));
        else {
            BigDecimal calculatedSin = sin.calculate(x, eps);
            return calculatedSin.divide(calculatedCos, 30, HALF_EVEN);
        }
    }

}

