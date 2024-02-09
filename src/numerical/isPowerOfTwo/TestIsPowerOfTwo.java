package numerical.isPowerOfTwo;

import static org.junit.Assert.assertEquals;
import static numerical.isPowerOfTwo.IsPowerOfTwo.*;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class TestIsPowerOfTwo {
    private final ByteArrayOutputStream out = new ByteArrayOutputStream();
    private final String s0 = "0, 'false'";
    private final String s1 = "1, 'true'";
    private final String s2 = "2, 'true'";
    private final String s_2 = "-2, 'true'";
    private final String s63 = "63, 'false'";
    private final String s_256 = "-256, 'true'";
    private final String sMaxHalf = "1073741824, 'true'";
    private final String sMin = "-2147483648, 'true'";

    @BeforeEach
    void setSystemOut() {
        System.setOut(new PrintStream(out));
    }

    @ParameterizedTest
    @CsvSource(value = {
            s0, s1, s2, s_2, s63, s_256, sMaxHalf, sMin
    })
    void testIsPowerOfTwo(int value, String expected) {
        isPowerOfTwo1(value);
        assertEquals(expected, out.toString().stripTrailing());
    }

    @ParameterizedTest
    @CsvSource(value = {
            s0, s1, s2, s_2, s63, s_256, sMaxHalf, sMin
    })
    void testIsPowerOfTwo2(int value, String expected) {
        isPowerOfTwo2(value);
        assertEquals(expected, out.toString().stripTrailing());
    }

    @ParameterizedTest
    @CsvSource(value = {
            s0, s1, s2, s_2, s63, s_256, sMaxHalf, sMin
    })
    void testIsPowerOfTwo3(int value, String expected) {
        isPowerOfTwo3(value);
        assertEquals(expected, out.toString().stripTrailing());
    }

    @ParameterizedTest
    @CsvSource(value = {
            s0, s1, s2, s_2, s63, s_256, sMaxHalf, sMin
    })
    void testIsPowerOfTwo4(int value, String expected) {
        isPowerOfTwo4(value);
        assertEquals(expected, out.toString().stripTrailing());
    }

    @AfterEach
    void restoreOut() {
        System.setOut(null);
    }
}