package sequence.isCorrectBrackets2;

import static org.junit.Assert.assertEquals;
import static sequence.isCorrectBrackets2.IsCorrectBrackets2.isCorrectBrackets2;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class TestIsCorrectBrackets2 {
    private final ByteArrayOutputStream out = new ByteArrayOutputStream();

    @BeforeEach
    void setSystemOut() {
        System.setOut(new PrintStream(out));
    }

    @ParameterizedTest(name = "{index}: {0} - {1}")
    @CsvSource(value = {
            "'()', 'true'",
            "'[]', 'true'",
            "'{}', 'true'",

            "'([][]  ){}', 'true'",
            "'([][]  ){lst = [1, 2]}', 'true'",
            "'([()()()..])', 'true'",
            "'([{([{([{}])}])}])', 'true'",
            "'(){[]}[({})[([{}])]]{([{{}}])}', 'true'",

            "'(', 'false'",
            "'[', 'false'",
            "'{', 'false'",
            "')', 'false'",
            "']', 'false'",
            "'}', 'false'",

            "')(', 'false'",
            "'][', 'false'",
            "'}{', 'false'",

            "'(]', 'false'",
            "'(}', 'false'",
            "'[)', 'false'",
            "'[}', 'false'",
            "'{)', 'false'",
            "'{]', 'false'",

            "'([)]', 'false'",
            "'({)}', 'false'",
            "'[(])', 'false'",
            "'[{]}', 'false'",
            "'{(})', 'false'",
            "'{[}]', 'false'",
    })
    void testIsCorrectBrackets2(String input, String expected) {
        isCorrectBrackets2(input);
        assertEquals(expected, out.toString().stripTrailing());
    }

    @AfterEach
    void restoreOut() {
        System.setOut(null);
    }
}