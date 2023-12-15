package string.countLower;

import static org.junit.Assert.assertEquals;
import static string.countLower.CountLower.countLower;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class TestCountLower {

    @ParameterizedTest
    @CsvSource(value = {
            "abcABCD12345, 3",
            "gggggggg1212321ABDCEFCE, 8",
            "2376423745dhdhdPPPP, 5",
            "1v2b3n4m5k6h7GDFGDFd, 7",
    })
    void testCountLower(String input, int expected) {
        assertEquals(expected, countLower(input));
    }
}