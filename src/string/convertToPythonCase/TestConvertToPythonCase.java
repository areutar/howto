package string.convertToPythonCase;

import static org.junit.Assert.assertEquals;
import static string.convertToPythonCase.ConvertToPythonCase.convertToPythonCase;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class TestConvertToPythonCase {
    private final ByteArrayOutputStream out = new ByteArrayOutputStream();

    @BeforeEach
    void setSystemOut() {
        System.setOut(new PrintStream(out));
    }

    @ParameterizedTest
    @CsvSource(value = {
            "'ThisIsCamelCased', 'this_is_camel_cased'",
            "'IsPrimeNumber', 'is_prime_number'",
            "'ConvertToInt32', 'convert_to_int32'",
            "'MyMethodThatDoSomething', 'my_method_that_do_something'",
            "'IsHeFreeToGo', 'is_he_free_to_go'",
            "'FBIIsWatchingYou', 'f_b_i_is_watching_you'"
    })
    void testConvertToPythonCase(String input, String expected) {
        convertToPythonCase(input);
        assertEquals(expected, out.toString().stripTrailing());
    }

    @AfterEach
    void restoreOut() {
        System.setOut(null);
    }
}