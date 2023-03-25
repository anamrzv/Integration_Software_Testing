package trigonometry;

import utils.AccuracyException;
import utils.Calculatable;

import java.math.BigDecimal;

import static java.math.RoundingMode.HALF_EVEN;

public class Cot implements Calculatable {
    private final Cos cos;
    private final Sin sin;

    public Cot() {
        this.cos = new Cos();
        this.sin = new Sin();
    }

    public Cot(Cos cos, Sin sin) {
        this.cos = cos;
        this.sin = sin;
    }

    public BigDecimal calculate(double x, double eps) throws AccuracyException, ArithmeticException {
        BigDecimal calculatedSin = sin.calculate(x, eps);
        if (calculatedSin.compareTo(BigDecimal.ZERO) == 0) return null;
        else {
            BigDecimal calculatedCos = cos.calculate(x, eps);
            return calculatedCos.divide(calculatedSin, 30, HALF_EVEN);
        }
    }
}

