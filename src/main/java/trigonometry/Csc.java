package trigonometry;

import utils.AccuracyException;
import utils.Calculatable;

import java.math.BigDecimal;

import static java.lang.String.format;
import static java.math.RoundingMode.HALF_EVEN;

public class Csc implements Calculatable {
    private final Sin sin;

    public Csc() {
        this.sin = new Sin();
    }
    public Csc(Sin sin) {
        this.sin = sin;
    }

    public BigDecimal calculate(double x, double eps) throws AccuracyException, ArithmeticException {
        BigDecimal calculatedSin = sin.calculate(x, eps);
        if (calculatedSin.compareTo(BigDecimal.ZERO) == 0) return null;
        else return BigDecimal.ONE.divide(calculatedSin, 30, HALF_EVEN);
    }

}
