package logarithms;

import exceptions.AccuracyException;
import exceptions.Calculatable;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class Ln implements Calculatable {
    public BigDecimal calculate(double x, double eps) throws AccuracyException, ArithmeticException {
        if (Math.abs(eps) >= 1)
            throw new AccuracyException("Can't calculate logarithmic function: epsilon doesn't meet condition -1 < eps < 1");
        else if (x <= 0) throw new ArithmeticException("Can't calculate logarithmic function: Ln doesn't exist for x <= 0");

        if (x == 1) return BigDecimal.ZERO;
        else if (x == Math.E) return BigDecimal.ONE;

        BigDecimal result = BigDecimal.ZERO;

        int n = 1;
        if (x < 1) {
            BigDecimal current_term = BigDecimal.valueOf(x - 1);
            BigDecimal power = current_term;
            while (current_term.abs().compareTo(BigDecimal.valueOf(eps)) > 0) {
                result = result.add(current_term);
                power = power.multiply(BigDecimal.valueOf(-1)).multiply(current_term);
                current_term = power.divide(BigDecimal.valueOf(++n), 30, RoundingMode.HALF_UP);
            }
        } else {
            int mul;
            BigDecimal num = BigDecimal.valueOf((x - 1) / (x + 1));
            BigDecimal current_term;

            boolean enoughAccuracy = false;

            for (int i = 1; !enoughAccuracy; i++) {
                mul = (2 * i) - 1;
                current_term = num.pow(mul);
                current_term = current_term.divide(BigDecimal.valueOf(mul), 30, RoundingMode.HALF_UP);
                result = result.add(current_term);

                if (current_term.compareTo(BigDecimal.valueOf(eps / 2)) < 0)
                    enoughAccuracy = true;
            }

            result = result.multiply(BigDecimal.valueOf(2));

        }
        return result;
    }
}
