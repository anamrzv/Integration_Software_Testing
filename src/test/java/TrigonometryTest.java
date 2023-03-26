import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import trigonometry.*;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.anyDouble;
import static org.mockito.ArgumentMatchers.eq;

public class TrigonometryTest {

    private static final double DELTA = 0.0001;

    @Test
    public void testCsc() {
        Sin sin = Mockito.spy(Sin.class);
        Csc csc = new Csc(sin);

        Mockito.when(sin.calculate(eq(0), anyDouble())).thenReturn(0d);
        Mockito.when(sin.calculate(eq(Math.PI/2), anyDouble())).thenReturn(1d);
        Mockito.when(sin.calculate(eq(Math.PI), anyDouble())).thenReturn(0d);
        Mockito.when(sin.calculate(eq(1.5*Math.PI), anyDouble())).thenReturn(-1d);
        Mockito.when(sin.calculate(eq(2*Math.PI), anyDouble())).thenReturn(0d);
        Mockito.when(sin.calculate(eq(-Math.PI/2), anyDouble())).thenReturn(-1d);
        Mockito.when(sin.calculate(eq(-Math.PI), anyDouble())).thenReturn(0d);
        Mockito.when(sin.calculate(eq(-1.5*Math.PI), anyDouble())).thenReturn(1d);
        Mockito.when(sin.calculate(eq(-2*Math.PI), anyDouble())).thenReturn(0d);

        Mockito.when(sin.calculate(eq(Math.PI / 4), anyDouble())).thenReturn(Math.sqrt(2) / 2);
        Mockito.when(sin.calculate(eq(Math.PI / 3), anyDouble())).thenReturn(Math.sqrt(3) / 2);
        Mockito.when(sin.calculate(eq(Math.PI / 6), anyDouble())).thenReturn(0.5);
        Mockito.when(sin.calculate(eq(-Math.PI / 4), anyDouble())).thenReturn(-Math.sqrt(2) / 2);
        Mockito.when(sin.calculate(eq(-Math.PI / 3), anyDouble())).thenReturn(-Math.sqrt(3) / 2);
        Mockito.when(sin.calculate(eq(-Math.PI / 6), anyDouble())).thenReturn(-0.5);
        Mockito.when(sin.calculate(eq(-3.7), anyDouble())).thenReturn(0.529836);

        assertEquals(2d, csc.calculate(Math.PI/6, 0.001));
        assertEquals(Math.sqrt(2), csc.calculate(Math.PI/4, 0.001), DELTA);
        assertEquals(Math.sqrt(3)*2/3, csc.calculate(Math.PI/3, 0.001), DELTA);
        assertEquals(1d, csc.calculate(Math.PI/2, 0.001));
        assertEquals(Double.NaN, csc.calculate(0, 0.001));
        assertEquals(Double.NaN,csc.calculate(Math.PI * 2, 0.001));
        assertEquals(Math.sqrt(3)*2/3, csc.calculate(2*Math.PI/3, 0.001), DELTA);
        assertEquals(Double.NaN,csc.calculate(Math.PI, 0.001));
        assertEquals(-2, csc.calculate(-Math.PI/6, 0.001));
        assertEquals(-Math.sqrt(2), csc.calculate(-Math.PI/4, 0.001), DELTA);
        assertEquals(-Math.sqrt(3)*2/3, csc.calculate(-Math.PI/3, 0.001), DELTA);
        assertEquals(-1, csc.calculate(-Math.PI/2, 0.001));
        assertEquals(1.88738, csc.calculate(-3.7, 0.0001), DELTA);
    }

    @Test
    public void testSec() {
        Cos cos = Mockito.spy(Cos.class);
        Sec sec = new Sec(cos);

        Mockito.when(cos.calculate(eq(0), anyDouble())).thenReturn(1d);
        Mockito.when(cos.calculate(eq(Math.PI/2), anyDouble())).thenReturn(0d);
        Mockito.when(cos.calculate(eq(Math.PI), anyDouble())).thenReturn(-1d);
        Mockito.when(cos.calculate(eq(1.5*Math.PI), anyDouble())).thenReturn(0d);
        Mockito.when(cos.calculate(eq(2*Math.PI), anyDouble())).thenReturn(1d);
        Mockito.when(cos.calculate(eq(-Math.PI/2), anyDouble())).thenReturn(0d);
        Mockito.when(cos.calculate(eq(-Math.PI), anyDouble())).thenReturn(-1d);
        Mockito.when(cos.calculate(eq(-1.5*Math.PI), anyDouble())).thenReturn(0d);
        Mockito.when(cos.calculate(eq(-2*Math.PI), anyDouble())).thenReturn(1d);

        Mockito.when(cos.calculate(eq(Math.PI / 4), anyDouble())).thenReturn(Math.sqrt(2) / 2);
        Mockito.when(cos.calculate(eq(Math.PI / 3), anyDouble())).thenReturn(0.5);
        Mockito.when(cos.calculate(eq(Math.PI / 6), anyDouble())).thenReturn(Math.sqrt(3) / 2);
        Mockito.when(cos.calculate(eq(-Math.PI / 4), anyDouble())).thenReturn(Math.sqrt(2) / 2);
        Mockito.when(cos.calculate(eq(-Math.PI / 3), anyDouble())).thenReturn(0.5);
        Mockito.when(cos.calculate(eq(-Math.PI / 6), anyDouble())).thenReturn(Math.sqrt(3) / 2);
        Mockito.when(cos.calculate(eq(-3.7), anyDouble())).thenReturn(-0.8481);

        assertEquals(1d, sec.calculate(0, 0.001), DELTA);
        assertEquals(1d, sec.calculate(Math.PI * 2, 0.001));
        assertEquals(-1d, sec.calculate(Math.PI, 0.001));
        assertEquals(-1d, sec.calculate(-Math.PI, 0.001));
        assertEquals(Double.NaN,sec.calculate(Math.PI/2, 0.001));
        assertEquals(Double.NaN,sec.calculate(-Math.PI/2, 0.001));
        assertEquals(-2d, sec.calculate(2*Math.PI/3, 0.001), DELTA);
        assertEquals(-2d, sec.calculate(-2*Math.PI/3, 0.001), DELTA);
        assertEquals(2d, sec.calculate(Math.PI/3, 0.001), DELTA);
        assertEquals(2d, sec.calculate(-Math.PI/3, 0.001), DELTA);
        assertEquals(Math.sqrt(2), sec.calculate(Math.PI/4, 0.001), DELTA);
        assertEquals(Math.sqrt(2), sec.calculate(-Math.PI/4, 0.001), DELTA);
        assertEquals(2*Math.sqrt(3) / 3, sec.calculate(Math.PI/6, 0.001), DELTA);
        assertEquals(2*Math.sqrt(3) / 3, sec.calculate(-Math.PI/6, 0.001), DELTA);
        assertEquals(-1.17911, sec.calculate(-3.7, 0.0001), DELTA);
    }

    @Test
    public void testTgAndCot() {
        Cos cos = Mockito.spy(Cos.class);
        Sin sin = Mockito.spy(Sin.class);

        Tg tan = new Tg(cos, sin);
        Cot cot = new Cot(cos, sin);

        Mockito.when(cos.calculate(eq(0), anyDouble())).thenReturn(1d);
        Mockito.when(cos.calculate(eq(Math.PI/2), anyDouble())).thenReturn(0d);
        Mockito.when(cos.calculate(eq(Math.PI), anyDouble())).thenReturn(-1d);
        Mockito.when(cos.calculate(eq(1.5*Math.PI), anyDouble())).thenReturn(0d);
        Mockito.when(cos.calculate(eq(2*Math.PI), anyDouble())).thenReturn(1d);
        Mockito.when(cos.calculate(eq(-Math.PI/2), anyDouble())).thenReturn(0d);
        Mockito.when(cos.calculate(eq(-Math.PI), anyDouble())).thenReturn(-1d);
        Mockito.when(cos.calculate(eq(-1.5*Math.PI), anyDouble())).thenReturn(0d);
        Mockito.when(cos.calculate(eq(-2*Math.PI), anyDouble())).thenReturn(1d);
        Mockito.when(cos.calculate(eq(Math.PI / 4), anyDouble())).thenReturn(Math.sqrt(2) / 2);
        Mockito.when(cos.calculate(eq(Math.PI / 3), anyDouble())).thenReturn(0.5);
        Mockito.when(cos.calculate(eq(Math.PI / 6), anyDouble())).thenReturn(Math.sqrt(3) / 2);
        Mockito.when(cos.calculate(eq(-Math.PI / 4), anyDouble())).thenReturn(Math.sqrt(2) / 2);
        Mockito.when(cos.calculate(eq(-Math.PI / 3), anyDouble())).thenReturn(0.5);
        Mockito.when(cos.calculate(eq(-Math.PI / 6), anyDouble())).thenReturn(Math.sqrt(3) / 2);
        Mockito.when(cos.calculate(eq(-3.7), anyDouble())).thenReturn(-0.8481);

        Mockito.when(sin.calculate(eq(0), anyDouble())).thenReturn(0d);
        Mockito.when(sin.calculate(eq(Math.PI/2), anyDouble())).thenReturn(1d);
        Mockito.when(sin.calculate(eq(Math.PI), anyDouble())).thenReturn(0d);
        Mockito.when(sin.calculate(eq(1.5*Math.PI), anyDouble())).thenReturn(-1d);
        Mockito.when(sin.calculate(eq(2*Math.PI), anyDouble())).thenReturn(0d);
        Mockito.when(sin.calculate(eq(-Math.PI/2), anyDouble())).thenReturn(-1d);
        Mockito.when(sin.calculate(eq(-Math.PI), anyDouble())).thenReturn(0d);
        Mockito.when(sin.calculate(eq(-1.5*Math.PI), anyDouble())).thenReturn(1d);
        Mockito.when(sin.calculate(eq(-2*Math.PI), anyDouble())).thenReturn(0d);
        Mockito.when(sin.calculate(eq(Math.PI / 4), anyDouble())).thenReturn(Math.sqrt(2) / 2);
        Mockito.when(sin.calculate(eq(Math.PI / 3), anyDouble())).thenReturn(Math.sqrt(3) / 2);
        Mockito.when(sin.calculate(eq(Math.PI / 6), anyDouble())).thenReturn(0.5);
        Mockito.when(sin.calculate(eq(-Math.PI / 4), anyDouble())).thenReturn(-Math.sqrt(2) / 2);
        Mockito.when(sin.calculate(eq(-Math.PI / 3), anyDouble())).thenReturn(-Math.sqrt(3) / 2);
        Mockito.when(sin.calculate(eq(-Math.PI / 6), anyDouble())).thenReturn(-0.5);
        Mockito.when(sin.calculate(eq(-3.7), anyDouble())).thenReturn(0.529836);

        assertEquals(0d, tan.calculate(0, 0.001), DELTA);
        assertEquals(Double.NaN,tan.calculate(Math.PI/2, 0.001));
        assertEquals(0d, tan.calculate(Math.PI, 0.001), DELTA);
        assertEquals(Double.NaN,tan.calculate(3*Math.PI/2, 0.001));
        assertEquals(1d, tan.calculate(Math.PI/4, 0.001), DELTA);
        assertEquals(Math.sqrt(3), tan.calculate(Math.PI/3, 0.001), DELTA);
        assertEquals(1/Math.sqrt(3), tan.calculate(Math.PI/6, 0.001), DELTA);
        assertEquals(-1d, tan.calculate(-Math.PI/4, 0.001), DELTA);
        assertEquals(-Math.sqrt(3), tan.calculate(-Math.PI/3, 0.001), DELTA);
        assertEquals(-1/Math.sqrt(3), tan.calculate(-Math.PI/6, 0.001), DELTA);
        assertEquals(-0.624733, tan.calculate(-3.7, 0.0001), DELTA);

        assertEquals(Double.NaN,cot.calculate(0, 0.001));
        assertEquals(0d, cot.calculate(Math.PI/2, 0.001), DELTA);
        assertEquals(Double.NaN,cot.calculate(Math.PI, 0.001));
        assertEquals(0d, cot.calculate(3*Math.PI/2, 0.001), DELTA);
        assertEquals(1d, cot.calculate(Math.PI/4, 0.001), DELTA);
        assertEquals(1/Math.sqrt(3), cot.calculate(Math.PI/3, 0.001), DELTA);
        assertEquals(Math.sqrt(3), cot.calculate(Math.PI/6, 0.001), DELTA);
        assertEquals(-1d, cot.calculate(-Math.PI/4, 0.001), DELTA);
        assertEquals(-Math.sqrt(3)/3, cot.calculate(-Math.PI/3, 0.001), DELTA);
        assertEquals(-Math.sqrt(3), cot.calculate(-Math.PI/6, 0.001), DELTA);
        assertEquals(-1.60068, cot.calculate(-3.7, 0.0001), DELTA);
    }

    @Test
    public void testSin(){
        Cos cos = Mockito.spy(Cos.class);
        Sin sin = new Sin(cos);

        Mockito.when(cos.calculate(eq(0), anyDouble())).thenReturn(1d);
        Mockito.when(cos.calculate(eq(Math.PI/2), anyDouble())).thenReturn(0d);
        Mockito.when(cos.calculate(eq(Math.PI), anyDouble())).thenReturn(-1d);
        Mockito.when(cos.calculate(eq(1.5*Math.PI), anyDouble())).thenReturn(0d);
        Mockito.when(cos.calculate(eq(2*Math.PI), anyDouble())).thenReturn(1d);
        Mockito.when(cos.calculate(eq(-Math.PI/2), anyDouble())).thenReturn(0d);
        Mockito.when(cos.calculate(eq(-Math.PI), anyDouble())).thenReturn(-1d);
        Mockito.when(cos.calculate(eq(-1.5*Math.PI), anyDouble())).thenReturn(0d);
        Mockito.when(cos.calculate(eq(-2*Math.PI), anyDouble())).thenReturn(1d);
        Mockito.when(cos.calculate(eq(-3.7), anyDouble())).thenReturn(-0.8481);

        Mockito.when(cos.calculate(eq(Math.PI / 4), anyDouble())).thenReturn(Math.sqrt(2) / 2);
        Mockito.when(cos.calculate(eq(Math.PI / 3), anyDouble())).thenReturn(0.5);
        Mockito.when(cos.calculate(eq(Math.PI / 6), anyDouble())).thenReturn(Math.sqrt(3) / 2);
        Mockito.when(cos.calculate(eq(-Math.PI / 4), anyDouble())).thenReturn(Math.sqrt(2) / 2);
        Mockito.when(cos.calculate(eq(-Math.PI / 3), anyDouble())).thenReturn(0.5);
        Mockito.when(cos.calculate(eq(-Math.PI / 6), anyDouble())).thenReturn(Math.sqrt(3) / 2);

        assertEquals(0d, sin.calculate(0, 0.001));
        assertEquals(1d, sin.calculate(Math.PI/2, 0.001));
        assertEquals(0d, sin.calculate(Math.PI, 0.001));
        assertEquals(-1d, sin.calculate(1.5*Math.PI, 0.001));
        assertEquals(0d, sin.calculate(2*Math.PI, 0.001));
        assertEquals(-1d, sin.calculate(-Math.PI/2, 0.001));
        assertEquals(0d, sin.calculate(-Math.PI, 0.001));
        assertEquals(1d, sin.calculate(-1.5*Math.PI, 0.001));
        assertEquals(0d, sin.calculate(-2*Math.PI, 0.001));
        assertEquals(Math.sqrt(2) / 2, sin.calculate(Math.PI / 4, 0.001), DELTA);
        assertEquals(Math.sqrt(3) / 2, sin.calculate(Math.PI / 3, 0.001), DELTA);
        assertEquals(0.5, sin.calculate(Math.PI / 6, 0.001), DELTA);
        assertEquals(-Math.sqrt(2) / 2, sin.calculate(-Math.PI / 4, 0.001), DELTA);
        assertEquals(-Math.sqrt(3) / 2, sin.calculate(-Math.PI / 3, 0.001), DELTA);
        assertEquals(-0.5, sin.calculate(-Math.PI / 6, 0.001), DELTA);
        assertEquals(0.529836, sin.calculate(-3.7, 0.0001), DELTA);
    }

    @Test
    public void testCos() {
        Cos cos = new Cos();
        assertEquals(1d, cos.calculate(0, 0.0001));
        assertEquals(0d, cos.calculate(Math.PI / 2, 0.0001));
        assertEquals(-1d, cos.calculate(Math.PI, 0.0001));
        assertEquals(0d, cos.calculate(1.5 * Math.PI, 0.0001));
        assertEquals(1d, cos.calculate(2 * Math.PI, 0.0001));

        assertEquals(0d, cos.calculate(-Math.PI / 2, 0.0001), DELTA);
        assertEquals(-1d, cos.calculate(-Math.PI, 0.0001), DELTA);
        assertEquals(0d, cos.calculate(-1.5 * Math.PI, 0.0001), DELTA);
        assertEquals(1d, cos.calculate(-2 * Math.PI, 0.0001), DELTA);

        assertEquals(Math.sqrt(2) / 2, cos.calculate(Math.PI / 4, 0.0001), DELTA);
        assertEquals(Math.sqrt(3) / 2, cos.calculate(Math.PI / 6, 0.0001), DELTA);
        assertEquals(0.5, cos.calculate(Math.PI / 3, 0.0001), DELTA);
        assertEquals(Math.sqrt(2) / 2, cos.calculate(-Math.PI / 4, 0.0001), DELTA);
        assertEquals(Math.sqrt(3) / 2, cos.calculate(-Math.PI / 6, 0.0001), DELTA);
        assertEquals(0.5, cos.calculate(-Math.PI / 3, 0.0001), DELTA);

        assertEquals(-0.8481, cos.calculate(-3.7, 0.0001), DELTA);
    }
}
