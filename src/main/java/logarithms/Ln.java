package logarithms;

import utils.AccuracyException;
import utils.Calculatable;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class Ln implements Calculatable {
    public double calculate(double x, double eps) throws AccuracyException, ArithmeticException {
        if (Math.abs(eps) >= 1)
            throw new AccuracyException("Can't calculate logarithmic function: epsilon doesn't meet condition -1 < eps < 1");
        else if (x <= 0) return Double.NaN;
        else if (Double.POSITIVE_INFINITY == x || Double.NEGATIVE_INFINITY == x) return Double.NaN;

        if (x == 1) return 0;
        else if (x == Math.E) return 1;

        BigDecimal result = BigDecimal.ZERO;

        int mul;
        BigDecimal num = BigDecimal.valueOf((x - 1) / (x + 1));
        BigDecimal current_term;

        BigDecimal prev_result = BigDecimal.ZERO;
        boolean enoughAccuracy = false;

        for (int i = 1; !enoughAccuracy; i++) {
            mul = (2 * i) - 1;
            current_term = num.pow(mul);
            current_term = current_term.divide(BigDecimal.valueOf(mul), 30, RoundingMode.HALF_UP);
            result = result.add(current_term);

            if (result.subtract(prev_result).abs().compareTo(BigDecimal.valueOf(eps)) < 0)
                enoughAccuracy = true;
            prev_result = result;
        }

        result = result.multiply(BigDecimal.valueOf(2));

        return result.doubleValue();
    }
}
