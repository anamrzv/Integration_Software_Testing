package trigonometry;

import utils.AccuracyException;
import utils.Calculatable;

import java.math.BigDecimal;

import static java.lang.String.format;
import static java.math.RoundingMode.HALF_EVEN;

public class Sec implements Calculatable {
    private final Cos cos;
    private final double DELTA = .1e-5;

    public Sec() {
        this.cos = new Cos();
    }

    public Sec(Cos cos) {
        this.cos = cos;
    }

    public double calculate(double x, double eps) throws AccuracyException, ArithmeticException {
        BigDecimal calculatedCos = BigDecimal.valueOf(cos.calculate(x, eps));
        if (calculatedCos.compareTo(BigDecimal.ZERO) == 0) return Double.NaN;
        else if (Math.abs(x - Math.PI / 2) <= DELTA || Math.abs(x - Math.PI * 3 / 2) <= DELTA) return Double.NaN;
        else return BigDecimal.ONE.divide(calculatedCos, 30, HALF_EVEN).doubleValue();
    }
}
