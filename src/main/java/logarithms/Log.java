package logarithms;

import exceptions.AccuracyException;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class Log {
    private final Ln ln;
    private final int base;

    public Log(int base) {
        this.base = base;
        this.ln = new Ln();
    }

    public BigDecimal calculate(double x, double eps) throws AccuracyException, ArithmeticException {
        if (x <= 0) throw new ArithmeticException("Log doesn't exist for x <= 0");
        else if (base <= 0 || base == 1) throw new ArithmeticException("Log doesn't exist for base <=0 or base == 1");

        return ln.calculate(x, eps).divide(ln.calculate(base, eps), 30, RoundingMode.HALF_UP);
    }
}
