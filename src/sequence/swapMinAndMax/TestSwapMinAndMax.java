package sequence.swapMinAndMax;

import static org.junit.Assert.assertEquals;
import static sequence.swapMinAndMax.SwapMinAndMax.swapMinAndMax;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class TestSwapMinAndMax {
    private final ByteArrayOutputStream out = new ByteArrayOutputStream();

    @BeforeEach
    void setSystemOut() {
        System.setOut(new PrintStream(out));
    }

    @ParameterizedTest
    @CsvSource(value = {
            "3 4 5 2 1, 3 4 1 2 5",
            "10 9 8 7 6 5 4 3 2 1, 1 9 8 7 6 5 4 3 2 10",
            "1 2, 2 1",
            "1, 1",
            "1 1 1 1 1, 1 1 1 1 1",
            "2 1, 1 2",
            "2 1 1, 1 2 2",
            "1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16 17 180 19 20 21 22, 180 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16 17 1 19 20 21 22",
            "1 2 3 4 5 6 7 8 9 10, 10 2 3 4 5 6 7 8 9 1",
            "1 5 4 3 2, 5 1 4 3 2"
    })
    void testSwapMinAndMax(String input, String expected) {
        swapMinAndMax(input);
        assertEquals(expected, out.toString().stripTrailing());
    }

    @AfterEach
    void restoreOut() {
        System.setOut(null);
    }
}