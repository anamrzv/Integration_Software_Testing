package trigonometry;

import utils.AccuracyException;
import utils.Calculatable;

import java.math.BigDecimal;

import static java.math.RoundingMode.HALF_EVEN;

public class Csc implements Calculatable {
    private final Sin sin;
    private final double DELTA = .1e-5;

    public Csc() {
        this.sin = new Sin();
    }

    public Csc(Sin sin) {
        this.sin = sin;
    }

    public double calculate(double x, double eps) throws AccuracyException, ArithmeticException {
        BigDecimal calculatedSin = BigDecimal.valueOf(sin.calculate(x, eps));
        if (calculatedSin.compareTo(BigDecimal.ZERO) == 0) return Double.NaN;
        else if (Math.abs(x) <= DELTA || Math.abs(x - Math.PI) <= DELTA) return Double.NaN;
        else return BigDecimal.ONE.divide(calculatedSin, 30, HALF_EVEN).doubleValue();
    }

}
