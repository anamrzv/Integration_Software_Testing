package trigonometry;

import utils.AccuracyException;
import utils.Calculatable;

import java.math.BigDecimal;

import static java.math.RoundingMode.HALF_EVEN;

public class Tg implements Calculatable {
    private final Cos cos;
    private final Sin sin;
    private final double DELTA = .1e-5;

    public Tg() {
        this.cos = new Cos();
        this.sin = new Sin();
    }

    public Tg(Cos cos, Sin sin) {
        this.cos = cos;
        this.sin = sin;
    }

    public Tg(Cos cos) {
        this.cos = cos;
        this.sin = new Sin(cos);
    }

    public double calculate(double x, double eps) throws AccuracyException, ArithmeticException {
        BigDecimal calculatedCos = BigDecimal.valueOf(cos.calculate(x, eps));
        if (calculatedCos.compareTo(BigDecimal.ZERO) == 0) return Double.NaN;
        else if (Math.abs(x - Math.PI / 2) <= DELTA || Math.abs(x - Math.PI * 3 / 2) <= DELTA)
            return Double.NaN;
        else {
            BigDecimal calculatedSin = BigDecimal.valueOf(sin.calculate(x, eps));
            return calculatedSin.divide(calculatedCos, 30, HALF_EVEN).doubleValue();
        }
    }

}

