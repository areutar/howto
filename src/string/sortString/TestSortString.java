package string.sortString;

import static org.junit.Assert.assertEquals;
import static string.sortString.SortString.sortString;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class TestSortString {

    @ParameterizedTest
    // @MethodSource("provideParams")
    @CsvSource(value = {
            "' ', ' '",
            "'a', 'a'",
            "'ab', 'ab'",
            "'a!a', '!aa'",
            "'a b', ' ab'",
            "'ba b', ' abb'",
            "'ёе', 'её'"
    })
    void testSortString(String input, String expected) {
        assertEquals(expected, sortString(input));
    }

}