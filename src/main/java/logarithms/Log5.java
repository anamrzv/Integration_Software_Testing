package logarithms;

import utils.AccuracyException;
import utils.Calculatable;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class Log5 implements Calculatable {
    private final Ln ln;
    private final int base = 5;

    public Log5() {
        this.ln = new Ln();
    }

    public Log5(Ln ln) {
        this.ln = ln;
    }

    public double calculate(double x, double eps) throws AccuracyException, ArithmeticException {
        if (x <= 0) return Double.NaN;
        return BigDecimal.valueOf(ln.calculate(x, eps)).divide(BigDecimal.valueOf(ln.calculate(base, eps)), 30, RoundingMode.HALF_UP).doubleValue();
    }
}
