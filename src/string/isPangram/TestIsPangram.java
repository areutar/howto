package string.isPangram;

import static org.junit.Assert.assertEquals;
import static string.isPangram.IsPangram.isPangram;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class TestIsPangram {
    private final ByteArrayOutputStream out = new ByteArrayOutputStream();

    @BeforeEach
    void setSystemOut() {
        System.setOut(new PrintStream(out));
    }

    @ParameterizedTest
    @CsvSource(value = {
            "'abcdefghijklmnopqrstuvwxyz', 'true'",
            "'The quick brown fox jumps over the lazy dog', 'true'",
            "'Jackdaws love my big sphinx of quartz', 'true'",
            "'The five boxing wizards jump quickly. ', 'true'",
            "'ddddddddddddddddddddddddddddddddddddddddddddddddddddddd', 'false'",
            "'abcdefghijklmnopqastuvwxyzabcdefghijklmnopq', 'false'",
            "'def test_is_pangram(input, expected, capsys):', 'false'",
            "' void testIsPangram(String input, String expected) {\r\n" + //
                    "        isPangram(input);\r\n" + //
                    "        assertEquals(expected, out.toString().stripTrailing());\r\n" + //
                    "    }', 'false'"
    })
    void testIsPangram(String input, String expected) {
        isPangram(input);
        assertEquals(expected, out.toString().stripTrailing());
    }

    @AfterEach
    void restoreOut() {
        System.setOut(null);
    }
}