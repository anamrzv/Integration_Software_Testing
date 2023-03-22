package trigonometry;

import java.math.BigDecimal;

import static java.lang.String.format;
import static java.math.RoundingMode.HALF_EVEN;

public class Sec {
    private final Cos cos;

    public Sec() {
        this.cos = new Cos();
    }

    public BigDecimal calculate(double x, double eps) {
        BigDecimal calculatedCos = cos.calculate(x, eps);
        if (calculatedCos.compareTo(BigDecimal.ZERO) == 0) throw new ArithmeticException(format("Sec value for argument %s doesn't exist", x));
        else return BigDecimal.ONE.divide(calculatedCos, 30, HALF_EVEN);
    }
}
