package logarithms;

import utils.AccuracyException;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class Log2 {
    private final Ln ln;
    private final int base = 2;

    public Log2() {
        this.ln = new Ln();
    }
    public Log2(Ln ln) {
        this.ln = ln;
    }

    public BigDecimal calculate(double x, double eps) throws AccuracyException, ArithmeticException {
        if (x <= 0) return null;//throw new ArithmeticException("Log2 doesn't exist for x <= 0");
        return ln.calculate(x, eps).divide(ln.calculate(base, eps), 30, RoundingMode.HALF_UP);
    }
}
