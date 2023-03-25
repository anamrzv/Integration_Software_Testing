import logarithms.Ln;
import logarithms.Log2;
import logarithms.Log3;
import logarithms.Log5;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.CsvSource;
import org.mockito.Mockito;
import trigonometry.*;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.anyDouble;
import static org.mockito.ArgumentMatchers.eq;

public class FunctionsSystemTest {
    private static final double DELTA = 0.0003;

    @BeforeAll
    public static void init() {
        Cos cos = new Cos();
        Sin sin = new Sin(cos);
        Csc csc = new Csc(sin);
        Sec sec = new Sec(cos);
        Tg tg = new Tg(cos, sin);
        Cot cot = new Cot(cos, sin);

        Ln ln = new Ln();
        Log2 log2 = new Log2(ln);
        Log3 log3 = new Log3(ln);
        Log5 log5 = new Log5(ln);

        //system = new FunctionsSystem(cos, sin, cot, tg, csc, sec, ln, log2, log3, log5);
    }

    @DisplayName("Test Functions' System with all Mocks")
    @ParameterizedTest
    @CsvSource(value = {
            "1,    0.0",
            "1.24,  0.3904",
            "0.7,   8.1143",
            "-3.824,    -0.02162",
            "-5.379,    7.2700",
            "-7.188,   -4.446",
            "-8.693,    -0.0095",
            "-3.771,    -0.3898",
            "-3.926,    -0.3982"
    })
    @Test
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

        Mockito.when(ln.calculate(eq(1), anyDouble())).thenReturn(BigDecimal.valueOf(0.0));
        Mockito.when(ln.calculate(eq(1.24), anyDouble())).thenReturn(BigDecimal.valueOf(0.215111));
        Mockito.when(ln.calculate(eq(0.7), anyDouble())).thenReturn(BigDecimal.valueOf(-0.356675));

        Mockito.when(log2.calculate(eq(1), anyDouble())).thenReturn(BigDecimal.valueOf(0.0));
        Mockito.when(log2.calculate(eq(1.24), anyDouble())).thenReturn(BigDecimal.valueOf(0.3103));
        Mockito.when(log2.calculate(eq(0.7), anyDouble())).thenReturn(BigDecimal.valueOf(-0.514573));

        Mockito.when(log3.calculate(eq(1), anyDouble())).thenReturn(BigDecimal.valueOf(0.0));
        Mockito.when(log3.calculate(eq(1.24), anyDouble())).thenReturn(BigDecimal.valueOf(0.1958));
        Mockito.when(log3.calculate(eq(0.7), anyDouble())).thenReturn(BigDecimal.valueOf(-0.3247));

        Mockito.when(log5.calculate(eq(1), anyDouble())).thenReturn(BigDecimal.valueOf(0.0));
        Mockito.when(log5.calculate(eq(1.24), anyDouble())).thenReturn(BigDecimal.valueOf(0.133656));
        Mockito.when(log5.calculate(eq(0.7), anyDouble())).thenReturn(BigDecimal.valueOf(-0.221615));

        Mockito.when(cos.calculate(eq(-3.824), anyDouble())).thenReturn(BigDecimal.valueOf(-0.776057));
        Mockito.when(cos.calculate(eq(-5.379), anyDouble())).thenReturn(BigDecimal.valueOf(0.618326));
        Mockito.when(cos.calculate(eq(-7.188), anyDouble())).thenReturn(BigDecimal.valueOf(0.617831));
        Mockito.when(cos.calculate(eq(-8.693), anyDouble())).thenReturn(BigDecimal.valueOf(-0.743988));
        Mockito.when(cos.calculate(eq(-3.771), anyDouble())).thenReturn(BigDecimal.valueOf(-0.808377));
        Mockito.when(cos.calculate(eq(-3.926), anyDouble())).thenReturn(BigDecimal.valueOf(-0.707807));

        Mockito.when(sin.calculate(eq(-3.824), anyDouble())).thenReturn(BigDecimal.valueOf(0.630432));
        Mockito.when(sin.calculate(eq(-5.379), anyDouble())).thenReturn(BigDecimal.valueOf(-0.785773));
        Mockito.when(sin.calculate(eq(-7.188), anyDouble())).thenReturn(BigDecimal.valueOf(-0.786232));
        Mockito.when(sin.calculate(eq(-8.693), anyDouble())).thenReturn(BigDecimal.valueOf(0.668593));
        Mockito.when(sin.calculate(eq(-3.771), anyDouble())).thenReturn(BigDecimal.valueOf(0.588083));
        Mockito.when(sin.calculate(eq(-3.926), anyDouble())).thenReturn(BigDecimal.valueOf(0.706346));

        Mockito.when(tg.calculate(eq(-3.824), anyDouble())).thenReturn(BigDecimal.valueOf(-0.810895));
        Mockito.when(tg.calculate(eq(-5.379), anyDouble())).thenReturn(BigDecimal.valueOf(1.132039));
        Mockito.when(tg.calculate(eq(-7.188), anyDouble())).thenReturn(BigDecimal.valueOf(0.879615));
        Mockito.when(tg.calculate(eq(-8.693), anyDouble())).thenReturn(BigDecimal.valueOf(-0.902439));
        Mockito.when(tg.calculate(eq(-3.771), anyDouble())).thenReturn(BigDecimal.valueOf(-1.151940));
        Mockito.when(tg.calculate(eq(-3.926), anyDouble())).thenReturn(BigDecimal.valueOf(-0.807935));

        Mockito.when(cot.calculate(eq(-3.824), anyDouble())).thenReturn(BigDecimal.valueOf(-1.232964));
        Mockito.when(cot.calculate(eq(-5.379), anyDouble())).thenReturn(BigDecimal.valueOf(0.884980));
        Mockito.when(cot.calculate(eq(-7.188), anyDouble())).thenReturn(BigDecimal.valueOf(1.135042));
        Mockito.when(cot.calculate(eq(-8.693), anyDouble())).thenReturn(BigDecimal.valueOf(-1.107726));
        Mockito.when(cot.calculate(eq(-3.771), anyDouble())).thenReturn(BigDecimal.valueOf(-0.869972));
        Mockito.when(cot.calculate(eq(-3.926), anyDouble())).thenReturn(BigDecimal.valueOf(-1.237759));

        Mockito.when(sec.calculate(eq(-3.824), anyDouble())).thenReturn(BigDecimal.valueOf(-1.227956));
        Mockito.when(sec.calculate(eq(-5.379), anyDouble())).thenReturn(BigDecimal.valueOf(1.613569));
        Mockito.when(sec.calculate(eq(-7.188), anyDouble())).thenReturn(BigDecimal.valueOf(1.603988));
        Mockito.when(sec.calculate(eq(-8.693), anyDouble())).thenReturn(BigDecimal.valueOf(-1.343458));
        Mockito.when(sec.calculate(eq(-3.771), anyDouble())).thenReturn(BigDecimal.valueOf(-1.703472));
        Mockito.when(sec.calculate(eq(-3.926), anyDouble())).thenReturn(BigDecimal.valueOf(-1.408023));

        Mockito.when(csc.calculate(eq(-3.824), anyDouble())).thenReturn(BigDecimal.valueOf(-1.262352));
        Mockito.when(csc.calculate(eq(-5.379), anyDouble())).thenReturn(BigDecimal.valueOf(-1.274679));
        Mockito.when(csc.calculate(eq(-7.188), anyDouble())).thenReturn(BigDecimal.valueOf(-1.277220));
        Mockito.when(csc.calculate(eq(-8.693), anyDouble())).thenReturn(BigDecimal.valueOf(1.340027));
        Mockito.when(csc.calculate(eq(-3.771), anyDouble())).thenReturn(BigDecimal.valueOf(-1.701863));
        Mockito.when(csc.calculate(eq(-3.926), anyDouble())).thenReturn(BigDecimal.valueOf(-1.410442));

        FunctionsSystem system = new FunctionsSystem(cos, sin, cot, tg, csc, sec, ln, log2, log3, log5);

        assertEquals(expectedResult, system.calculate(x, 0.000001).doubleValue(), DELTA);
    }

}
