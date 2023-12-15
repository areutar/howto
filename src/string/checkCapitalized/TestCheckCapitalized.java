package string.checkCapitalized;

import static org.junit.Assert.assertEquals;
import static string.checkCapitalized.CheckCapitalized.checkCapitalized;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class TestCheckCapitalized {

    @ParameterizedTest
    @CsvSource(value = {
            "chris alan, false",
            "Chris Alan, true",
            "chris Alan, false",
            "Chris alan, false",
    })
    void testCheckCapitalized(String input, boolean expected) {
        assertEquals(expected, checkCapitalized(input));
    }
}