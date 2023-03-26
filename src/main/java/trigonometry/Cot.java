package trigonometry;

import utils.AccuracyException;
import utils.Calculatable;

import java.math.BigDecimal;

import static java.math.RoundingMode.HALF_EVEN;

public class Cot implements Calculatable {
    private final Cos cos;
    private final Sin sin;
    private final double DELTA = .1e-5;

    public Cot() {
        this.cos = new Cos();
        this.sin = new Sin();
    }

    public Cot(Cos cos, Sin sin) {
        this.cos = cos;
        this.sin = sin;
    }

    public double calculate(double x, double eps) throws AccuracyException, ArithmeticException {
        BigDecimal calculatedSin = BigDecimal.valueOf(sin.calculate(x, eps));
        if (calculatedSin.compareTo(BigDecimal.ZERO) == 0) return Double.NaN;
        else if (Math.abs(x - Math.PI) <= DELTA || Math.abs(x - 2 * Math.PI) <= DELTA)
            return Double.NaN;
        else {
            BigDecimal calculatedCos = BigDecimal.valueOf(cos.calculate(x, eps));
            return calculatedCos.divide(calculatedSin, 30, HALF_EVEN).doubleValue();
        }
    }
}

