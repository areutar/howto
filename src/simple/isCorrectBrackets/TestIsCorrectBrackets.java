package simple.isCorrectBrackets;

import static org.junit.Assert.assertEquals;
import static simple.isCorrectBrackets.IsCorrectBrackets.isCorrectBrackets;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class TestIsCorrectBrackets {
    private final ByteArrayOutputStream out = new ByteArrayOutputStream();

    @BeforeEach
    void setSystemOut() {
        System.setOut(new PrintStream(out));
    }

    @ParameterizedTest
    @CsvSource(value = {
            "'((()))', 'true'",
            "'(()())', 'true'",
            "'(())()', 'true'",
            "'()(())', 'true'",
            "'()()()', 'true'",
            "'()(())()()()(())()(()())((()))', 'true'",
            "'()(())()(()())((()))()(())', 'true'",
            "'())()()()(', 'false'",
            "')))(((', 'false'",
            "'()(())()((())((()))()(())', 'false'",
            "'()(())()(()())((()))()(()', 'false'",
            "')(())()(()())((()))()(())', 'false'",
            "'())(()', 'false'",
            "')))', 'false'",
            "'((((', 'false'",
            "'())((((())))', 'false'"
    })
    void testIsCorrectBrackets(String input, String expected) {
        isCorrectBrackets(input);
        assertEquals(expected, out.toString().stripTrailing());
    }

    @AfterEach
    void restoreOut() {
        System.setOut(null);
    }
}