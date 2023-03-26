import logarithms.Ln;
import logarithms.Log2;
import logarithms.Log3;
import logarithms.Log5;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.mockito.Mockito;
import trigonometry.*;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.anyDouble;
import static org.mockito.ArgumentMatchers.eq;

public class FunctionsSystemTest {
    private static final double DELTA = 0.0003;

    @DisplayName("Test Functions' System with all Mocks")
    @ParameterizedTest
    @CsvSource(value = {
            "0.98, 0.0",
            "1,    0.0",
            "1.02,  0.0",
            "1.24,  0.3904",
            "0.7,   8.1143",
            "-3.824,  -0.0016",
            "-3.926,   -0.2525",
            "-3.771,   0.0918",
            "-0.81,    11.70449",
            "-0.7,    145.6593",
            "-0.9,    -1.72E-4",
            "-5.379, -0.0018"
    })
    public void tableValuesTest(double x, double expectedResult) {
        Ln ln = Mockito.spy(Ln.class);
        Log2 log2 = Mockito.spy(Log2.class);
        Log3 log3 = Mockito.spy(Log3.class);
        Log5 log5 = Mockito.spy(Log5.class);
        Cos cos = Mockito.spy(Cos.class);
        Sin sin = Mockito.spy(Sin.class);
        Csc csc = Mockito.spy(Csc.class);
        Sec sec = Mockito.spy(Sec.class);
        Tg tg = Mockito.spy(Tg.class);
        Cot cot = Mockito.spy(Cot.class);

        Mockito.when(ln.calculate(eq(0.98), anyDouble())).thenReturn(-0.0202);
        Mockito.when(ln.calculate(eq(1), anyDouble())).thenReturn(0.0);
        Mockito.when(ln.calculate(eq(1.24), anyDouble())).thenReturn(0.215111);
        Mockito.when(ln.calculate(eq(1.02), anyDouble())).thenReturn(0.0198);
        Mockito.when(ln.calculate(eq(0.7), anyDouble())).thenReturn(-0.356675);

        Mockito.when(log2.calculate(eq(1), anyDouble())).thenReturn(0.0);
        Mockito.when(log2.calculate(eq(1.24), anyDouble())).thenReturn(0.3103);
        Mockito.when(log2.calculate(eq(0.7), anyDouble())).thenReturn(-0.514573);
        Mockito.when(log2.calculate(eq(0.98), anyDouble())).thenReturn(-0.029);
        Mockito.when(log2.calculate(eq(1.02), anyDouble())).thenReturn(0.028);

        Mockito.when(log3.calculate(eq(1), anyDouble())).thenReturn(0.0);
        Mockito.when(log3.calculate(eq(1.24), anyDouble())).thenReturn(0.1958);
        Mockito.when(log3.calculate(eq(0.7), anyDouble())).thenReturn(-0.3247);
        Mockito.when(log2.calculate(eq(0.98), anyDouble())).thenReturn(-0.0184);
        Mockito.when(log2.calculate(eq(1.02), anyDouble())).thenReturn(0.018);

        Mockito.when(log5.calculate(eq(1), anyDouble())).thenReturn(0.0);
        Mockito.when(log5.calculate(eq(1.24), anyDouble())).thenReturn(0.133656);
        Mockito.when(log5.calculate(eq(0.7), anyDouble())).thenReturn(-0.221615);
        Mockito.when(log2.calculate(eq(0.98), anyDouble())).thenReturn(-0.0125);
        Mockito.when(log2.calculate(eq(1.02), anyDouble())).thenReturn(0.0123);

        Mockito.when(cos.calculate(eq(-3.824), anyDouble())).thenReturn(-0.776057);
        Mockito.when(cos.calculate(eq(-3.926), anyDouble())).thenReturn(-0.707807);
        Mockito.when(cos.calculate(eq(-3.771), anyDouble())).thenReturn(-0.808377);
        Mockito.when(cos.calculate(eq(-0.81), anyDouble())).thenReturn(0.6894);
        Mockito.when(cos.calculate(eq(-0.7), anyDouble())).thenReturn(0.764);
        Mockito.when(cos.calculate(eq(-0.9), anyDouble())).thenReturn(0.621);
        Mockito.when(cos.calculate(eq(-5.379), anyDouble())).thenReturn(0.618326);
        Mockito.when(cos.calculate(eq(-7.188), anyDouble())).thenReturn(0.617831);
        Mockito.when(cos.calculate(eq(-8.693), anyDouble())).thenReturn(-0.743988);

        Mockito.when(sin.calculate(eq(-3.824), anyDouble())).thenReturn(0.63066);
        Mockito.when(sin.calculate(eq(-5.379), anyDouble())).thenReturn(0.785922);
        Mockito.when(sin.calculate(eq(-7.188), anyDouble())).thenReturn(-0.786311);
        Mockito.when(sin.calculate(eq(-8.693), anyDouble())).thenReturn(-0.66819);
        Mockito.when(sin.calculate(eq(-3.771), anyDouble())).thenReturn(0.58866);
        Mockito.when(sin.calculate(eq(-3.926), anyDouble())).thenReturn(0.706406);
        Mockito.when(sin.calculate(eq(-0.81), anyDouble())).thenReturn(-0.724);
        Mockito.when(sin.calculate(eq(-0.7), anyDouble())).thenReturn(-0.6442176872);
        Mockito.when(sin.calculate(eq(-0.9), anyDouble())).thenReturn(-0.7833269096);

        Mockito.when(tg.calculate(eq(-3.824), anyDouble())).thenReturn(-0.8126);
        Mockito.when(tg.calculate(eq(-5.379), anyDouble())).thenReturn(1.27105);
        Mockito.when(tg.calculate(eq(-7.188), anyDouble())).thenReturn(-1.27269);
        Mockito.when(tg.calculate(eq(-8.693), anyDouble())).thenReturn(0.898125);
        Mockito.when(tg.calculate(eq(-3.771), anyDouble())).thenReturn(-0.7282);
        Mockito.when(tg.calculate(eq(-3.926), anyDouble())).thenReturn(-0.99802);
        Mockito.when(tg.calculate(eq(-0.81), anyDouble())).thenReturn(-1.05);
        Mockito.when(tg.calculate(eq(-0.7), anyDouble())).thenReturn(-0.842);
        Mockito.when(tg.calculate(eq(-0.9), anyDouble())).thenReturn(-1.26);

        Mockito.when(cot.calculate(eq(-3.824), anyDouble())).thenReturn(-1.2305);
        Mockito.when(cot.calculate(eq(-5.379), anyDouble())).thenReturn(0.786753);
        Mockito.when(cot.calculate(eq(-7.188), anyDouble())).thenReturn(-0.78573);
        Mockito.when(cot.calculate(eq(-8.693), anyDouble())).thenReturn(-1.11343);
        Mockito.when(cot.calculate(eq(-3.771), anyDouble())).thenReturn(-1.3732);
        Mockito.when(cot.calculate(eq(-3.926), anyDouble())).thenReturn(-1.00198);
        Mockito.when(cot.calculate(eq(-0.81), anyDouble())).thenReturn(-0.95);
        Mockito.when(cot.calculate(eq(-0.7), anyDouble())).thenReturn(-1.187);
        Mockito.when(cot.calculate(eq(-0.9), anyDouble())).thenReturn(-0.79);

        Mockito.when(sec.calculate(eq(-3.824), anyDouble())).thenReturn(-1.28857);
        Mockito.when(sec.calculate(eq(-5.379), anyDouble())).thenReturn(1.61727);
        Mockito.when(sec.calculate(eq(-7.188), anyDouble())).thenReturn(1.61856);
        Mockito.when(sec.calculate(eq(-8.693), anyDouble())).thenReturn(-1.34411);
        Mockito.when(sec.calculate(eq(-3.771), anyDouble())).thenReturn(-1.23705);
        Mockito.when(sec.calculate(eq(-3.926), anyDouble())).thenReturn(-1.41281);
        Mockito.when(sec.calculate(eq(-0.81), anyDouble())).thenReturn(1.45);
        Mockito.when(sec.calculate(eq(-0.7), anyDouble())).thenReturn(1.307);
        Mockito.when(sec.calculate(eq(-0.9), anyDouble())).thenReturn(1.6087);

        Mockito.when(csc.calculate(eq(-3.824), anyDouble())).thenReturn(-1.5856);
        Mockito.when(csc.calculate(eq(-5.379), anyDouble())).thenReturn(-1.27239);
        Mockito.when(csc.calculate(eq(-7.188), anyDouble())).thenReturn(-1.27717);
        Mockito.when(csc.calculate(eq(-8.693), anyDouble())).thenReturn(-1.49657);
        Mockito.when(csc.calculate(eq(-3.771), anyDouble())).thenReturn(1.6987);
        Mockito.when(csc.calculate(eq(-3.926), anyDouble())).thenReturn(1.4156);
        Mockito.when(csc.calculate(eq(-0.81), anyDouble())).thenReturn(-1.38);
        Mockito.when(csc.calculate(eq(-0.7), anyDouble())).thenReturn(-1.55);
        Mockito.when(csc.calculate(eq(-0.9), anyDouble())).thenReturn(-1.27);

        FunctionsSystem system = new FunctionsSystem(cos, sin, cot, tg, csc, sec, ln, log2, log3, log5);

        assertEquals(expectedResult, system.calculate(x, 0.000001), DELTA);
    }

    @DisplayName("Test Functions' System without Mocks")
    @ParameterizedTest
    @CsvSource(value = {
            "0.98, 0.0",
            "1,    0.0",
            "1.02,  0.0",
            "1.24,  0.3904",
            "0.7,   8.1129",
            "-3.824,  -0.0004",
            "-3.926,   -0.2525",
            "-3.771,   0.0918",
            "-0.81,    12.2651",
            "-0.7,    150.9448",
            "-0.9,    0.001471",
            "-5.379, -0.0018"
    })
    public void integrateTest(double x, double expectedResult) {
        FunctionsSystem system = new FunctionsSystem();
        assertEquals(expectedResult, system.calculate(x, 0.000001), DELTA);
    }

}
