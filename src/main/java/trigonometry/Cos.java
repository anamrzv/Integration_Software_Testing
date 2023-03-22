package trigonometry;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class Cos {
    public BigDecimal cos(double x, double eps) throws AccuracyException, ArithmeticException {

        if (Math.abs(eps) >= 1)
            throw new AccuracyException("Can't calculate COS: epsilon doesn't meet condition -1 < eps < 1");
        if (Double.POSITIVE_INFINITY == x || Double.NEGATIVE_INFINITY == x)
            throw new ArithmeticException("Can't calculate COS: x can't an Infinity");

        if (x >= 0) {
            while (x > 2 * Math.PI) {
                x -= 2 * Math.PI;
            }
        } else {
            while (x < 2 * Math.PI) {
                x += 2 * Math.PI;
            }
        }

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
            System.out.println(result);
        } while (result.subtract(previous_result).abs().compareTo(BigDecimal.valueOf(eps)) == 1);
        return result;
    }
}
