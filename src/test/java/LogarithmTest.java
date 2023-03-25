import logarithms.Ln;
import logarithms.Log2;
import logarithms.Log3;
import logarithms.Log5;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import utils.AccuracyException;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyDouble;
import static org.mockito.ArgumentMatchers.eq;

public class LogarithmTest {

    private static final double DELTA = 0.0001;

    @Test
    public void testLog(){
        Ln ln = Mockito.spy(Ln.class);
        Log5 log5 = new Log5(ln);
        Log3 log3 = new Log3(ln);
        Log2 log2 = new Log2(ln);

        Mockito.when(ln.calculate(eq(4), anyDouble())).thenReturn(BigDecimal.valueOf(1.3863));
        Mockito.when(ln.calculate(eq(9), anyDouble())).thenReturn(BigDecimal.valueOf(2.1972));
        Mockito.when(ln.calculate(eq(25), anyDouble())).thenReturn(BigDecimal.valueOf(3.2189));
        Mockito.when(ln.calculate(eq(0), anyDouble())).thenReturn(null);
        Mockito.when(ln.calculate(eq(-1), anyDouble())).thenReturn(null);
        Mockito.when(ln.calculate(eq(0.5), anyDouble())).thenReturn(BigDecimal.valueOf(-0.6931));
        Mockito.when(ln.calculate(eq(0.3333), anyDouble())).thenReturn(BigDecimal.valueOf(-1.0987));
        Mockito.when(ln.calculate(eq(0.2), anyDouble())).thenReturn(BigDecimal.valueOf(-1.6094));
        Mockito.when(ln.calculate(eq(1), anyDouble())).thenReturn(BigDecimal.valueOf(0));
        Mockito.when(ln.calculate(eq(Math.sqrt(2)), anyDouble())).thenReturn(BigDecimal.valueOf(0.3466));
        Mockito.when(ln.calculate(eq(Math.sqrt(3)), anyDouble())).thenReturn(BigDecimal.valueOf(0.5493));
        Mockito.when(ln.calculate(eq(Math.sqrt(5)), anyDouble())).thenReturn(BigDecimal.valueOf(0.8047));

        assertEquals(2, log2.calculate(4, 0.0001).doubleValue(), DELTA);
        assertEquals(0, log2.calculate(1, 0.0001).doubleValue(), DELTA);
        assertEquals(0.5, log2.calculate(Math.sqrt(2), 0.0001).doubleValue(), DELTA);
        assertEquals(-1, log2.calculate(0.5, 0.0001).doubleValue(), DELTA);

        assertEquals(2, log3.calculate(9, 0.00001).doubleValue(), DELTA);
        assertEquals(0, log3.calculate(1, 0.0001).doubleValue(), DELTA);
        assertEquals(0.5, log3.calculate(Math.sqrt(3), 0.0001).doubleValue(), DELTA);
        assertEquals(-1, log3.calculate(0.3333, 0.00001).doubleValue(), DELTA);

        assertEquals(2, log5.calculate(25, 0.00001).doubleValue(), DELTA);
        assertEquals(0, log5.calculate(1, 0.0001).doubleValue(), DELTA);
        assertEquals(0.5, log5.calculate(Math.sqrt(5), 0.0001).doubleValue(), DELTA);
        assertEquals(-1, log5.calculate(0.2, 0.0001).doubleValue(), DELTA);


        assertNull(log2.calculate(0, 0.0001));
        assertNull(log2.calculate(-1, 0.0001));
        assertNull(log3.calculate(0, 0.0001));
        assertNull(log3.calculate(-1, 0.0001));
        assertNull(log5.calculate(0, 0.0001));
        assertNull(log5.calculate(-1, 0.0001));
    }

    @Test
    public void testLn() {
        Ln ln = new Ln();
        assertNull(ln.calculate(0, 0.0001));
        assertNull(ln.calculate(-1, 0.001));
        assertEquals(0, ln.calculate(1, 0.001).doubleValue());
        assertEquals(1, ln.calculate(Math.E, 0.001).doubleValue());
        assertEquals(0.6931, ln.calculate(2, 0.0001).doubleValue(), DELTA);
        assertEquals(0.3466, ln.calculate(Math.sqrt(2), 0.0001).doubleValue(), DELTA);
        assertEquals(3.2189, ln.calculate(25, 0.000001).doubleValue(), DELTA);
        assertEquals(-1.6094, ln.calculate(0.2, 0.000001).doubleValue(), DELTA);
        assertThrows(AccuracyException.class, () -> ln.calculate(2, -2));
    }
}
