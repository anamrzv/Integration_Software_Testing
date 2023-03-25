package logarithms;

import utils.AccuracyException;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class Log5 {
    private final Ln ln;
    private final int base = 5;

    public Log5() {
        this.ln = new Ln();
    }

    public Log5(Ln ln) {
        this.ln = ln;
    }

    public BigDecimal calculate(double x, double eps) throws AccuracyException, ArithmeticException {
        if (x <= 0) return null;//throw new ArithmeticException("Log5 doesn't exist for x <= 0");
        return ln.calculate(x, eps).divide(ln.calculate(base, eps), 30, RoundingMode.HALF_UP);
    }
}
