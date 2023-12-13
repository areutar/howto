package string.countDigits;

import static org.junit.Assert.assertEquals;
import static string.countDigits.CountDigits.countDigits;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class TestCountDigits {
    @ParameterizedTest
    @CsvSource(value = {
            "nezabud dl-6, 1",
            "l33t 3301, 6",
            "1029384756aaa1234567890, 20",
            "jehfkjshfkjsdk90909090, 8"
    })
    void testCountDigits(String input, int expected) {
        assertEquals(expected, countDigits(input));
    }
}
