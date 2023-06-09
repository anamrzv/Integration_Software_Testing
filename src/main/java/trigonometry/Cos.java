package trigonometry;

import utils.AccuracyException;
import utils.Calculatable;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class Cos implements Calculatable {
    public double calculate(double x, double eps) throws AccuracyException, ArithmeticException {
        if (Math.abs(eps) >= 1)
            throw new AccuracyException("Can't calculate trigonometric function: epsilon doesn't meet condition -1 < eps < 1");
        else if (Double.POSITIVE_INFINITY == x || Double.NEGATIVE_INFINITY == x)
            throw new ArithmeticException("Can't calculate trigonometric function: x can't be an Infinity");

        if (x >= 0) {
            while (x > 2 * Math.PI) {
                x -= 2 * Math.PI;
            }
        } else {
            while (x < -2 * Math.PI) {
                x += 2 * Math.PI;
            }
        }

        if (Math.abs(x) == Math.PI / 2 || Math.abs(x) == Math.PI / 2 * 3) return 0;
        else if (Math.abs(x) == 2 * Math.PI) return 1;
        else if (Math.abs(x) == Math.PI) return -1;

        BigDecimal result = BigDecimal.ONE;
        BigDecimal previous_result;
        int n = 2;
        int sign = -1;
        BigDecimal factorial = BigDecimal.valueOf(2.0);
        do {
            previous_result = result;
            result = result.add(BigDecimal.valueOf(sign * Math.pow(x, n)).divide(factorial, 30, RoundingMode.HALF_UP));
            factorial = factorial.multiply(BigDecimal.valueOf(n + 1)).multiply(BigDecimal.valueOf(n + 2));
            n += 2;
            sign *= -1;
        } while (result.subtract(previous_result).abs().compareTo(BigDecimal.valueOf(eps)) > 0);
        return result.doubleValue();
    }
}
