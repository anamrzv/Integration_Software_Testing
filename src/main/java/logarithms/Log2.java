package logarithms;

import utils.AccuracyException;
import utils.Calculatable;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class Log2 implements Calculatable {
    private final Ln ln;
    private final int base = 2;

    public Log2() {
        this.ln = new Ln();
    }
    public Log2(Ln ln) {
        this.ln = ln;
    }

    public double calculate(double x, double eps) throws AccuracyException, ArithmeticException {
        if (x <= 0) return Double.NaN;
        return BigDecimal.valueOf(ln.calculate(x, eps)).divide(BigDecimal.valueOf(ln.calculate(base, eps)), 30, RoundingMode.HALF_UP).doubleValue();
    }
}
