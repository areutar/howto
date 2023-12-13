package string.everyThird;

import static org.junit.Assert.assertEquals;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class TestEveryThird {
    @ParameterizedTest
    @CsvSource(value = {
            "Python, yton",
            "Hello, elo",
            "qwer, we",
            "p, ''",
            "ab, b",
            "abc, bc",
            "abcdefg, bcef",
            "abcdefghij, bcefhi",
            "abcdefghijkl, bcefhikl",
            "qwertyuiopasdfghjklzxcvbnm, wetyioasfgjkzxvbm",
            "карандаш, арндш",
    })
    void testEveryThird(String input, String expected) {
        assertEquals(expected, EveryThird.everyThird(input));
    }
}
