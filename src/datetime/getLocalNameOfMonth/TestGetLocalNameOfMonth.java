package datetime.getLocalNameOfMonth;

import static org.junit.Assert.assertEquals;
import static datetime.getLocalNameOfMonth.GetLocalNameOfMonth.getLocalNameOfMonth;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class TestGetLocalNameOfMonth {
    private final ByteArrayOutputStream out = new ByteArrayOutputStream();

    @BeforeEach
    void setSystemOut() {
        System.setOut(new PrintStream(out));
    }

    @ParameterizedTest
    @CsvSource(value = {
            "'ru', 1, 'январь'",
            "'ru', 2, 'февраль'",
            "'ru', 3, 'март'",
            "'ru', 4, 'апрель'",
            "'ru', 5, 'май'",
            "'ru', 6, 'июнь'",
            "'ru', 7, 'июль'",
            "'ru', 8, 'август'",
            "'ru', 9, 'сентябрь'",
            "'ru', 10, 'октябрь'",
            "'ru', 11, 'ноябрь'",
            "'ru', 12, 'декабрь'",
            "'en', 1, 'january'",
            "'en', 2, 'february'",
            "'en', 3, 'march'",
            "'en', 4, 'april'",
            "'en', 5, 'may'",
            "'en', 6, 'june'",
            "'en', 7, 'july'",
            "'en', 8, 'august'",
            "'en', 9, 'september'",
            "'en', 10, 'october'",
            "'en', 11, 'november'",
            "'en', 12, 'december'"
    })
    void testGetLocalNameOfMonth(String lang, int number, String expected) {
        getLocalNameOfMonth(lang, number);
        assertEquals(expected, out.toString().stripTrailing());
    }

    @AfterEach
    void restoreOut() {
        System.setOut(null);
    }
}