package string.listOfAllChars;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

public class TestListOfAllChars {
    @ParameterizedTest
    @MethodSource("provideParams")
    void testListOfAllChars(List<String> strings, List<Character> expected) {
        assertEquals(expected, ListOfAllChars.listOfAllChars(strings));
    }

    public static Stream<Arguments> provideParams() {
        return Stream.of(
                Arguments.of(List.of("abc", "def", "ghi"),
                        Arrays.asList('a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i')),

                Arguments.of(List.of("asdfgh", "nvbfghtuge",
                        "djnsmdcnks", "ncjsdkncsdjkcn", "dscnmscsm"),
                        Arrays.asList('a', 's', 'd', 'f', 'g', 'h', 'n', 'v', 'b', 'f', 'g', 'h', 't', 'u', 'g', 'e',
                                'd', 'j', 'n', 's', 'm', 'd', 'c', 'n', 'k', 's', 'n', 'c', 'j', 's', 'd', 'k', 'n',
                                'c', 's', 'd', 'j', 'k', 'c', 'n', 'd', 's', 'c', 'n', 'm', 's', 'c', 's', 'm')),
                Arguments.of(List.of("poiuytrewq"),
                        Arrays.asList('p', 'o', 'i', 'u', 'y', 't', 'r', 'e', 'w', 'q')),

                Arguments.of(List.of("098765", "4321"),
                        Arrays.asList('0', '9', '8', '7', '6', '5', '4', '3', '2', '1')));
    }
}
