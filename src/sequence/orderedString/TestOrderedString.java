package sequence.orderedString;

import static org.junit.Assert.assertEquals;
import static sequence.orderedString.OrderedString.orderedString;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class TestOrderedString {
    private final ByteArrayOutputStream out = new ByteArrayOutputStream();

    @BeforeEach
    void setSystemOut() {
        System.setOut(new PrintStream(out));
    }

    @ParameterizedTest
    @CsvSource(value = {
            "5321, true",
            "7820, false",
            "9663, true",
            "9876543210, true",
            "987654329, false",
            "12345, false",
            "54332222221111, true",
            "987654341, false",
            "98768974321, false",
            "987654328, false",
            "111111111, true",
            "6543211, true",
            "6593211, false",
    })
    void testOrderedString(String input, String expected) {
        orderedString(input);
        assertEquals(expected, out.toString().stripTrailing());
    }

    @AfterEach
    void restoreOut() {
        System.setOut(null);
    }
}