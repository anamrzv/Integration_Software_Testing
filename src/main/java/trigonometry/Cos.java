package trigonometry;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class Cos {
    public BigDecimal calculate(double x, double eps) throws AccuracyException, ArithmeticException {

        if (Math.abs(eps) >= 1)
            throw new AccuracyException("Can't calculate trigonometric function: epsilon doesn't meet condition -1 < eps < 1");
        if (Double.POSITIVE_INFINITY == x || Double.NEGATIVE_INFINITY == x)
            throw new ArithmeticException("Can't calculate trigonometric function: x can't be an Infinity");

        if (x >= 0) {
            while (x > 2 * Math.PI) {
                x -= 2 * Math.PI;
            }
        } else {
            while (x < 2 * Math.PI) {
                x += 2 * Math.PI;
            }
        }

        if (x == Math.PI / 2) return BigDecimal.ZERO;
        else if (x == 2 * Math.PI) return BigDecimal.ONE;
        else if (x == Math.PI) return BigDecimal.ONE.multiply(BigDecimal.valueOf(-1));

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
        return result;
    }
}
