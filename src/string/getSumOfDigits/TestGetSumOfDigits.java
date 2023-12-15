package string.getSumOfDigits;

import static org.junit.Assert.assertEquals;
import static string.getSumOfDigits.GetSumOfDigits.getSumOfDigits;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class TestGetSumOfDigits {

    @ParameterizedTest
    @CsvSource(value = {
            "2514, 12",
            "12, 3",
            "12345, 15",
            "7777777777, 70",
    })
    void testGetSumOfDigits(String input, int expected) {
        assertEquals(expected, getSumOfDigits(input));
    }
}