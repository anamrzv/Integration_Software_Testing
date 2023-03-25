import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import trigonometry.*;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.ArgumentMatchers.anyDouble;
import static org.mockito.ArgumentMatchers.eq;

public class TrigonometryTest {

    private static final double DELTA = 0.0001;

    @Test
    public void testCsc() {
        Sin sin = Mockito.spy(Sin.class);
        Csc csc = new Csc(sin);

        Mockito.when(sin.calculate(eq(0), anyDouble())).thenReturn(BigDecimal.ZERO);
        Mockito.when(sin.calculate(eq(Math.PI/2), anyDouble())).thenReturn(BigDecimal.ONE);
        Mockito.when(sin.calculate(eq(Math.PI), anyDouble())).thenReturn(BigDecimal.ZERO);
        Mockito.when(sin.calculate(eq(1.5*Math.PI), anyDouble())).thenReturn(BigDecimal.valueOf(-1));
        Mockito.when(sin.calculate(eq(2*Math.PI), anyDouble())).thenReturn(BigDecimal.ZERO);
        Mockito.when(sin.calculate(eq(-Math.PI/2), anyDouble())).thenReturn(BigDecimal.valueOf(-1));
        Mockito.when(sin.calculate(eq(-Math.PI), anyDouble())).thenReturn(BigDecimal.ZERO);
        Mockito.when(sin.calculate(eq(-1.5*Math.PI), anyDouble())).thenReturn(BigDecimal.ONE);
        Mockito.when(sin.calculate(eq(-2*Math.PI), anyDouble())).thenReturn(BigDecimal.ZERO);

        Mockito.when(sin.calculate(eq(Math.PI / 4), anyDouble())).thenReturn(BigDecimal.valueOf(Math.sqrt(2) / 2));
        Mockito.when(sin.calculate(eq(Math.PI / 3), anyDouble())).thenReturn(BigDecimal.valueOf(Math.sqrt(3) / 2));
        Mockito.when(sin.calculate(eq(Math.PI / 6), anyDouble())).thenReturn(BigDecimal.valueOf(0.5));
        Mockito.when(sin.calculate(eq(-Math.PI / 4), anyDouble())).thenReturn(BigDecimal.valueOf(-Math.sqrt(2) / 2));
        Mockito.when(sin.calculate(eq(-Math.PI / 3), anyDouble())).thenReturn(BigDecimal.valueOf(-Math.sqrt(3) / 2));
        Mockito.when(sin.calculate(eq(-Math.PI / 6), anyDouble())).thenReturn(BigDecimal.valueOf(-0.5));

        assertEquals(2, csc.calculate(Math.PI/6, 0.001).doubleValue());
        assertEquals(Math.sqrt(2), csc.calculate(Math.PI/4, 0.001).doubleValue(), DELTA);
        assertEquals(Math.sqrt(3)*2/3, csc.calculate(Math.PI/3, 0.001).doubleValue(), DELTA);
        assertEquals(1, csc.calculate(Math.PI/2, 0.001).doubleValue());
        assertNull(csc.calculate(0, 0.001));
        assertNull(csc.calculate(Math.PI * 2, 0.001));
        assertEquals(Math.sqrt(3)*2/3, csc.calculate(2*Math.PI/3, 0.001).doubleValue(), DELTA);
        assertNull(csc.calculate(Math.PI, 0.001));
        assertEquals(-2, csc.calculate(-Math.PI/6, 0.001).doubleValue());
        assertEquals(-Math.sqrt(2), csc.calculate(-Math.PI/4, 0.001).doubleValue(), DELTA);
        assertEquals(-Math.sqrt(3)*2/3, csc.calculate(-Math.PI/3, 0.001).doubleValue(), DELTA);
        assertEquals(-1, csc.calculate(-Math.PI/2, 0.001).doubleValue());
    }

    @Test
    public void testSec() {
        Cos cos = Mockito.spy(Cos.class);
        Sec sec = new Sec(cos);

        Mockito.when(cos.calculate(eq(0), anyDouble())).thenReturn(BigDecimal.ONE);
        Mockito.when(cos.calculate(eq(Math.PI/2), anyDouble())).thenReturn(BigDecimal.ZERO);
        Mockito.when(cos.calculate(eq(Math.PI), anyDouble())).thenReturn(BigDecimal.valueOf(-1));
        Mockito.when(cos.calculate(eq(1.5*Math.PI), anyDouble())).thenReturn(BigDecimal.ZERO);
        Mockito.when(cos.calculate(eq(2*Math.PI), anyDouble())).thenReturn(BigDecimal.ONE);
        Mockito.when(cos.calculate(eq(-Math.PI/2), anyDouble())).thenReturn(BigDecimal.ZERO);
        Mockito.when(cos.calculate(eq(-Math.PI), anyDouble())).thenReturn(BigDecimal.valueOf(-1));
        Mockito.when(cos.calculate(eq(-1.5*Math.PI), anyDouble())).thenReturn(BigDecimal.ZERO);
        Mockito.when(cos.calculate(eq(-2*Math.PI), anyDouble())).thenReturn(BigDecimal.ONE);

        Mockito.when(cos.calculate(eq(Math.PI / 4), anyDouble())).thenReturn(BigDecimal.valueOf(Math.sqrt(2) / 2));
        Mockito.when(cos.calculate(eq(Math.PI / 3), anyDouble())).thenReturn(BigDecimal.valueOf(0.5));
        Mockito.when(cos.calculate(eq(Math.PI / 6), anyDouble())).thenReturn(BigDecimal.valueOf(Math.sqrt(3) / 2));
        Mockito.when(cos.calculate(eq(-Math.PI / 4), anyDouble())).thenReturn(BigDecimal.valueOf(Math.sqrt(2) / 2));
        Mockito.when(cos.calculate(eq(-Math.PI / 3), anyDouble())).thenReturn(BigDecimal.valueOf(0.5));
        Mockito.when(cos.calculate(eq(-Math.PI / 6), anyDouble())).thenReturn(BigDecimal.valueOf(Math.sqrt(3) / 2));

        assertEquals(1, sec.calculate(0, 0.001).doubleValue(), DELTA);
        assertEquals(1, sec.calculate(Math.PI * 2, 0.001).doubleValue());
        assertEquals(-1, sec.calculate(Math.PI, 0.001).doubleValue());
        assertEquals(-1, sec.calculate(-Math.PI, 0.001).doubleValue());
        assertNull(sec.calculate(Math.PI/2, 0.001));
        assertNull(sec.calculate(-Math.PI/2, 0.001));
        assertEquals(-2, sec.calculate(2*Math.PI/3, 0.001).doubleValue(), DELTA);
        assertEquals(-2, sec.calculate(-2*Math.PI/3, 0.001).doubleValue(), DELTA);
        assertEquals(2, sec.calculate(Math.PI/3, 0.001).doubleValue(), DELTA);
        assertEquals(2, sec.calculate(-Math.PI/3, 0.001).doubleValue(), DELTA);
        assertEquals(Math.sqrt(2), sec.calculate(Math.PI/4, 0.001).doubleValue(), DELTA);
        assertEquals(Math.sqrt(2), sec.calculate(-Math.PI/4, 0.001).doubleValue(), DELTA);
        assertEquals(2*Math.sqrt(3) / 3, sec.calculate(Math.PI/6, 0.001).doubleValue(), DELTA);
        assertEquals(2*Math.sqrt(3) / 3, sec.calculate(-Math.PI/6, 0.001).doubleValue(), DELTA);
    }

    @Test
    public void testTgAndCot() {
        Cos cos = Mockito.spy(Cos.class);
        Sin sin = Mockito.spy(Sin.class);

        Tg tan = new Tg(cos, sin);
        Cot cot = new Cot(cos, sin);

        Mockito.when(cos.calculate(eq(0), anyDouble())).thenReturn(BigDecimal.ONE);
        Mockito.when(cos.calculate(eq(Math.PI/2), anyDouble())).thenReturn(BigDecimal.ZERO);
        Mockito.when(cos.calculate(eq(Math.PI), anyDouble())).thenReturn(BigDecimal.valueOf(-1));
        Mockito.when(cos.calculate(eq(1.5*Math.PI), anyDouble())).thenReturn(BigDecimal.ZERO);
        Mockito.when(cos.calculate(eq(2*Math.PI), anyDouble())).thenReturn(BigDecimal.ONE);
        Mockito.when(cos.calculate(eq(-Math.PI/2), anyDouble())).thenReturn(BigDecimal.ZERO);
        Mockito.when(cos.calculate(eq(-Math.PI), anyDouble())).thenReturn(BigDecimal.valueOf(-1));
        Mockito.when(cos.calculate(eq(-1.5*Math.PI), anyDouble())).thenReturn(BigDecimal.ZERO);
        Mockito.when(cos.calculate(eq(-2*Math.PI), anyDouble())).thenReturn(BigDecimal.ONE);
        Mockito.when(cos.calculate(eq(Math.PI / 4), anyDouble())).thenReturn(BigDecimal.valueOf(Math.sqrt(2) / 2));
        Mockito.when(cos.calculate(eq(Math.PI / 3), anyDouble())).thenReturn(BigDecimal.valueOf(0.5));
        Mockito.when(cos.calculate(eq(Math.PI / 6), anyDouble())).thenReturn(BigDecimal.valueOf(Math.sqrt(3) / 2));
        Mockito.when(cos.calculate(eq(-Math.PI / 4), anyDouble())).thenReturn(BigDecimal.valueOf(Math.sqrt(2) / 2));
        Mockito.when(cos.calculate(eq(-Math.PI / 3), anyDouble())).thenReturn(BigDecimal.valueOf(0.5));
        Mockito.when(cos.calculate(eq(-Math.PI / 6), anyDouble())).thenReturn(BigDecimal.valueOf(Math.sqrt(3) / 2));

        Mockito.when(sin.calculate(eq(0), anyDouble())).thenReturn(BigDecimal.ZERO);
        Mockito.when(sin.calculate(eq(Math.PI/2), anyDouble())).thenReturn(BigDecimal.ONE);
        Mockito.when(sin.calculate(eq(Math.PI), anyDouble())).thenReturn(BigDecimal.ZERO);
        Mockito.when(sin.calculate(eq(1.5*Math.PI), anyDouble())).thenReturn(BigDecimal.valueOf(-1));
        Mockito.when(sin.calculate(eq(2*Math.PI), anyDouble())).thenReturn(BigDecimal.ZERO);
        Mockito.when(sin.calculate(eq(-Math.PI/2), anyDouble())).thenReturn(BigDecimal.valueOf(-1));
        Mockito.when(sin.calculate(eq(-Math.PI), anyDouble())).thenReturn(BigDecimal.ZERO);
        Mockito.when(sin.calculate(eq(-1.5*Math.PI), anyDouble())).thenReturn(BigDecimal.ONE);
        Mockito.when(sin.calculate(eq(-2*Math.PI), anyDouble())).thenReturn(BigDecimal.ZERO);
        Mockito.when(sin.calculate(eq(Math.PI / 4), anyDouble())).thenReturn(BigDecimal.valueOf(Math.sqrt(2) / 2));
        Mockito.when(sin.calculate(eq(Math.PI / 3), anyDouble())).thenReturn(BigDecimal.valueOf(Math.sqrt(3) / 2));
        Mockito.when(sin.calculate(eq(Math.PI / 6), anyDouble())).thenReturn(BigDecimal.valueOf(0.5));
        Mockito.when(sin.calculate(eq(-Math.PI / 4), anyDouble())).thenReturn(BigDecimal.valueOf(-Math.sqrt(2) / 2));
        Mockito.when(sin.calculate(eq(-Math.PI / 3), anyDouble())).thenReturn(BigDecimal.valueOf(-Math.sqrt(3) / 2));
        Mockito.when(sin.calculate(eq(-Math.PI / 6), anyDouble())).thenReturn(BigDecimal.valueOf(-0.5));

        assertEquals(0, tan.calculate(0, 0.001).doubleValue(), DELTA);
        assertNull(tan.calculate(Math.PI/2, 0.001));
        assertEquals(0, tan.calculate(Math.PI, 0.001).doubleValue(), DELTA);
        assertNull(tan.calculate(3*Math.PI/2, 0.001));
        assertEquals(1, tan.calculate(Math.PI/4, 0.001).doubleValue(), DELTA);
        assertEquals(Math.sqrt(3), tan.calculate(Math.PI/3, 0.001).doubleValue(), DELTA);
        assertEquals(1/Math.sqrt(3), tan.calculate(Math.PI/6, 0.001).doubleValue(), DELTA);
        assertEquals(-1, tan.calculate(-Math.PI/4, 0.001).doubleValue(), DELTA);
        assertEquals(-Math.sqrt(3), tan.calculate(-Math.PI/3, 0.001).doubleValue(), DELTA);
        assertEquals(-1/Math.sqrt(3), tan.calculate(-Math.PI/6, 0.001).doubleValue(), DELTA);

        assertNull(cot.calculate(0, 0.001));
        assertEquals(0, cot.calculate(Math.PI/2, 0.001).doubleValue(), DELTA);
        assertNull(cot.calculate(Math.PI, 0.001));
        assertEquals(0, cot.calculate(3*Math.PI/2, 0.001).doubleValue(), DELTA);
        assertEquals(1, cot.calculate(Math.PI/4, 0.001).doubleValue(), DELTA);
        assertEquals(1/Math.sqrt(3), cot.calculate(Math.PI/3, 0.001).doubleValue(), DELTA);
        assertEquals(Math.sqrt(3), cot.calculate(Math.PI/6, 0.001).doubleValue(), DELTA);
        assertEquals(-1, cot.calculate(-Math.PI/4, 0.001).doubleValue(), DELTA);
        assertEquals(-Math.sqrt(3)/3, cot.calculate(-Math.PI/3, 0.001).doubleValue(), DELTA);
        assertEquals(-Math.sqrt(3), cot.calculate(-Math.PI/6, 0.001).doubleValue(), DELTA);
    }

    @Test
    public void testSin(){
        Cos cos = Mockito.spy(Cos.class);
        Sin sin = new Sin(cos);

        Mockito.when(cos.calculate(eq(0), anyDouble())).thenReturn(BigDecimal.ONE);
        Mockito.when(cos.calculate(eq(Math.PI/2), anyDouble())).thenReturn(BigDecimal.ZERO);
        Mockito.when(cos.calculate(eq(Math.PI), anyDouble())).thenReturn(BigDecimal.valueOf(-1));
        Mockito.when(cos.calculate(eq(1.5*Math.PI), anyDouble())).thenReturn(BigDecimal.ZERO);
        Mockito.when(cos.calculate(eq(2*Math.PI), anyDouble())).thenReturn(BigDecimal.ONE);
        Mockito.when(cos.calculate(eq(-Math.PI/2), anyDouble())).thenReturn(BigDecimal.ZERO);
        Mockito.when(cos.calculate(eq(-Math.PI), anyDouble())).thenReturn(BigDecimal.valueOf(-1));
        Mockito.when(cos.calculate(eq(-1.5*Math.PI), anyDouble())).thenReturn(BigDecimal.ZERO);
        Mockito.when(cos.calculate(eq(-2*Math.PI), anyDouble())).thenReturn(BigDecimal.ONE);

        Mockito.when(cos.calculate(eq(Math.PI / 4), anyDouble())).thenReturn(BigDecimal.valueOf(Math.sqrt(2) / 2));
        Mockito.when(cos.calculate(eq(Math.PI / 3), anyDouble())).thenReturn(BigDecimal.valueOf(0.5));
        Mockito.when(cos.calculate(eq(Math.PI / 6), anyDouble())).thenReturn(BigDecimal.valueOf(Math.sqrt(3) / 2));
        Mockito.when(cos.calculate(eq(-Math.PI / 4), anyDouble())).thenReturn(BigDecimal.valueOf(Math.sqrt(2) / 2));
        Mockito.when(cos.calculate(eq(-Math.PI / 3), anyDouble())).thenReturn(BigDecimal.valueOf(0.5));
        Mockito.when(cos.calculate(eq(-Math.PI / 6), anyDouble())).thenReturn(BigDecimal.valueOf(Math.sqrt(3) / 2));

        assertEquals(0, sin.calculate(0, 0.001).doubleValue());
        assertEquals(1, sin.calculate(Math.PI/2, 0.001).doubleValue());
        assertEquals(0, sin.calculate(Math.PI, 0.001).doubleValue());
        assertEquals(BigDecimal.valueOf(-1), sin.calculate(1.5*Math.PI, 0.001));
        assertEquals(BigDecimal.ZERO, sin.calculate(2*Math.PI, 0.001));
        assertEquals(-1, sin.calculate(-Math.PI/2, 0.001).doubleValue());
        assertEquals(BigDecimal.ZERO, sin.calculate(-Math.PI, 0.001));
        assertEquals(BigDecimal.ONE, sin.calculate(-1.5*Math.PI, 0.001));
        assertEquals(BigDecimal.ZERO, sin.calculate(-2*Math.PI, 0.001));
        assertEquals(Math.sqrt(2) / 2, sin.calculate(Math.PI / 4, 0.001).doubleValue(), DELTA);
        assertEquals(Math.sqrt(3) / 2, sin.calculate(Math.PI / 3, 0.001).doubleValue(), DELTA);
        assertEquals(0.5, sin.calculate(Math.PI / 6, 0.001).doubleValue(), DELTA);
        assertEquals(-Math.sqrt(2) / 2, sin.calculate(-Math.PI / 4, 0.001).doubleValue(), DELTA);
        assertEquals(-Math.sqrt(3) / 2, sin.calculate(-Math.PI / 3, 0.001).doubleValue(), DELTA);
        assertEquals(-0.5, sin.calculate(-Math.PI / 6, 0.001).doubleValue(), DELTA);
    }

    @Test
    public void testCos() {
        Cos cos = new Cos();
        assertEquals(1, cos.calculate(0, 0.0001).doubleValue());
        assertEquals(0, cos.calculate(Math.PI / 2, 0.0001).doubleValue());
        assertEquals(-1, cos.calculate(Math.PI, 0.0001).doubleValue());
        assertEquals(0, cos.calculate(1.5 * Math.PI, 0.0001).doubleValue());
        assertEquals(1, cos.calculate(2 * Math.PI, 0.0001).doubleValue());

        assertEquals(0, cos.calculate(-Math.PI / 2, 0.0001).doubleValue(), DELTA);
        assertEquals(-1, cos.calculate(-Math.PI, 0.0001).doubleValue(), DELTA);
        assertEquals(0, cos.calculate(-1.5 * Math.PI, 0.0001).doubleValue(), DELTA);
        assertEquals(1, cos.calculate(-2 * Math.PI, 0.0001).doubleValue(), DELTA);

        assertEquals(Math.sqrt(2) / 2, cos.calculate(Math.PI / 4, 0.0001).doubleValue(), DELTA);
        assertEquals(Math.sqrt(3) / 2, cos.calculate(Math.PI / 6, 0.0001).doubleValue(), DELTA);
        assertEquals(0.5, cos.calculate(Math.PI / 3, 0.0001).doubleValue(), DELTA);
        assertEquals(Math.sqrt(2) / 2, cos.calculate(-Math.PI / 4, 0.0001).doubleValue(), DELTA);
        assertEquals(Math.sqrt(3) / 2, cos.calculate(-Math.PI / 6, 0.0001).doubleValue(), DELTA);
        assertEquals(0.5, cos.calculate(-Math.PI / 3, 0.0001).doubleValue(), DELTA);
    }
}
