package string.countEqualNeighbours;

import static org.junit.Assert.assertEquals;
import static string.countEqualNeighbours.CountEqualNeighbours.countEqualNeighbours;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class TestCountEqualNeighbours {

    @ParameterizedTest
    @CsvSource(value = {
            "abcd, 0",
            "aabbcc, 3",
            "333, 2",
            "aaaabbccd, 5",
            "aaabbaaa, 5",
    })
    void testCountEqualNeighbours(String input, int expected) {
        assertEquals(expected, countEqualNeighbours(input));
    }
}