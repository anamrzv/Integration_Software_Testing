import logarithms.Ln;
import logarithms.Log2;
import logarithms.Log3;
import logarithms.Log5;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import utils.AccuracyException;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyDouble;
import static org.mockito.ArgumentMatchers.eq;

public class LogarithmTest {

    private static final double DELTA = 0.0001;

    @DisplayName("Test Logs with Ln Mock")
    @Test
    public void testLog() {
        Ln ln = Mockito.spy(Ln.class);
        Log5 log5 = new Log5(ln);
        Log3 log3 = new Log3(ln);
        Log2 log2 = new Log2(ln);

        Mockito.when(ln.calculate(eq(4), anyDouble())).thenReturn(1.3863);
        Mockito.when(ln.calculate(eq(9), anyDouble())).thenReturn(2.1972);
        Mockito.when(ln.calculate(eq(25), anyDouble())).thenReturn(3.2189);
        Mockito.when(ln.calculate(eq(0), anyDouble())).thenReturn(Double.NaN);
        Mockito.when(ln.calculate(eq(-1), anyDouble())).thenReturn(Double.NaN);
        Mockito.when(ln.calculate(eq(0.5), anyDouble())).thenReturn(-0.6931);
        Mockito.when(ln.calculate(eq(0.3333), anyDouble())).thenReturn(-1.0987);
        Mockito.when(ln.calculate(eq(0.2), anyDouble())).thenReturn(-1.6094);
        Mockito.when(ln.calculate(eq(1), anyDouble())).thenReturn(0d);
        Mockito.when(ln.calculate(eq(Math.sqrt(2)), anyDouble())).thenReturn(0.3466);
        Mockito.when(ln.calculate(eq(Math.sqrt(3)), anyDouble())).thenReturn(0.5493);
        Mockito.when(ln.calculate(eq(Math.sqrt(5)), anyDouble())).thenReturn(0.8047);

        assertEquals(2, log2.calculate(4, 0.0001), DELTA);
        assertEquals(0, log2.calculate(1, 0.0001), DELTA);
        assertEquals(0.5, log2.calculate(Math.sqrt(2), 0.0001), DELTA);
        assertEquals(-1, log2.calculate(0.5, 0.0001), DELTA);

        assertEquals(2, log3.calculate(9, 0.00001), DELTA);
        assertEquals(0, log3.calculate(1, 0.0001), DELTA);
        assertEquals(0.5, log3.calculate(Math.sqrt(3), 0.0001), DELTA);
        assertEquals(-1, log3.calculate(0.3333, 0.00001), DELTA);

        assertEquals(2, log5.calculate(25, 0.00001), DELTA);
        assertEquals(0, log5.calculate(1, 0.0001), DELTA);
        assertEquals(0.5, log5.calculate(Math.sqrt(5), 0.0001), DELTA);
        assertEquals(-1, log5.calculate(0.2, 0.0001), DELTA);

        assertEquals(Double.NaN, log2.calculate(0, 0.0001));
        assertEquals(Double.NaN, log2.calculate(-1, 0.0001));
        assertEquals(Double.NaN, log3.calculate(0, 0.0001));
        assertEquals(Double.NaN, log3.calculate(-1, 0.0001));
        assertEquals(Double.NaN, log5.calculate(0, 0.0001));
        assertEquals(Double.NaN, log5.calculate(-1, 0.0001));
    }

    @DisplayName("Test Ln")
    @Test
    public void testLn() {
        Ln ln = new Ln();
        assertEquals(Double.NaN, ln.calculate(0, 0.0001));
        assertEquals(Double.NaN, ln.calculate(-1, 0.001));
        assertEquals(0, ln.calculate(1, 0.001));
        assertEquals(1, ln.calculate(Math.E, 0.001));
        assertEquals(0.6931, ln.calculate(2, 0.0001), DELTA);
        assertEquals(0.3466, ln.calculate(Math.sqrt(2), 0.0001), DELTA);
        assertEquals(3.2189, ln.calculate(25, 0.000001), DELTA);
        assertEquals(-1.6094, ln.calculate(0.2, 0.000001), DELTA);
        assertThrows(AccuracyException.class, () -> ln.calculate(2, -2));
    }

    @DisplayName("Test Logs without Ln Mock")
    @Test
    public void integrateTest() {
        Log5 log5 = new Log5();
        Log3 log3 = new Log3();
        Log2 log2 = new Log2();

        assertEquals(2, log2.calculate(4, 0.0001), DELTA);
        assertEquals(0, log2.calculate(1, 0.0001), DELTA);
        assertEquals(0.5, log2.calculate(Math.sqrt(2), 0.0001), DELTA);
        assertEquals(-1, log2.calculate(0.5, 0.0001), DELTA);

        assertEquals(2, log3.calculate(9, 0.00001), DELTA);
        assertEquals(0, log3.calculate(1, 0.0001), DELTA);
        assertEquals(0.5, log3.calculate(Math.sqrt(3), 0.0001), DELTA);
        assertEquals(-1, log3.calculate(0.3333, 0.00001), DELTA);

        assertEquals(2, log5.calculate(25, 0.00001), DELTA);
        assertEquals(0, log5.calculate(1, 0.0001), DELTA);
        assertEquals(0.5, log5.calculate(Math.sqrt(5), 0.0001), DELTA);
        assertEquals(-1, log5.calculate(0.2, 0.0001), DELTA);


        assertEquals(Double.NaN, log2.calculate(0, 0.0001));
        assertEquals(Double.NaN, log2.calculate(-1, 0.0001));
        assertEquals(Double.NaN, log3.calculate(0, 0.0001));
        assertEquals(Double.NaN, log3.calculate(-1, 0.0001));
        assertEquals(Double.NaN, log5.calculate(0, 0.0001));
        assertEquals(Double.NaN, log5.calculate(-1, 0.0001));
    }
}
