package string.longestWord;

import static org.junit.Assert.assertEquals;
import static string.longestWord.LongestWord.longestWord;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class TestLongestWord {

    @ParameterizedTest
    @CsvSource(value = {
            "проспал почти всю ночь, 7",
            "s ss fffffff qqqqqq aaaaaaaaaaaaaaaaaaaa qq, 20",
            "qwerty, 6",
            "python is awesome, 7",
            "qqqqqqqqqqqqqqqqqqqqqqqq pppppppppppp, 24"
    })

    void testLongestWord(String input, int expected) {
        assertEquals(expected, longestWord(input));
    }
}