package numerical.isValidTriangle;

import static org.junit.Assert.assertEquals;
import static numerical.isValidTriangle.IsValidTriangle.isValidTriangle;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class TestIsValidTriangle {
    private final ByteArrayOutputStream out = new ByteArrayOutputStream();

    @BeforeEach
    void setSystemOut() {
        System.setOut(new PrintStream(out));
    }

    @ParameterizedTest
    @CsvSource(value = {
            "'2 2 2', 'true'",
            "'2 3 10', false",
            "'3 4 5', true",
            "'10 11 12', true",
            "'12 10 2', false",
            "'100 1 2', false"
    })
    void testIsValidTriangle(String input, String expected) {
        isValidTriangle(input);
        assertEquals(expected, out.toString().stripTrailing());
    }

    @AfterEach
    void restoreOut() {
        System.setOut(null);
    }
}