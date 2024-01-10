package datetime.getMonthLength;

import static org.junit.Assert.assertEquals;
import static datetime.getMonthLength.GetMonthLength.getMonthLength;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class TestGetMonthLength {
    private final ByteArrayOutputStream out = new ByteArrayOutputStream();

    @BeforeEach
    void setSystemOut() {
        System.setOut(new PrintStream(out));
    }

    @ParameterizedTest
    @CsvSource(value = {
            "1, 31",
            "2, 29",
            "3, 31",
            "11, 30",
            "12, 31"
    })
    void testGetMonthLength(int month, String expected) {
        getMonthLength(month);
        assertEquals(expected, out.toString().stripTrailing());
    }

    @AfterEach
    void restoreOut() {
        System.setOut(null);
    }
}