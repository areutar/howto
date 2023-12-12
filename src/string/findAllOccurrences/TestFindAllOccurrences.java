package string.findAllOccurrences;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static string.findAllOccurrences.FindAllOccurrences.findAllOccurrences;

import java.util.List;
import java.util.stream.Stream;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

public class TestFindAllOccurrences {
    @ParameterizedTest
    @MethodSource("provideParams")
    void testFindAllOccurrences(String target, char ch, List<Integer> indices) {
        assertEquals(indices, findAllOccurrences(target, ch));
    }

  private static Stream<Arguments> provideParams (){
    return Stream.of(
      Arguments.of("abcdabcaaa", 'a', List.of(0, 4, 7, 8, 9)),
      Arguments.of("abcadabcaaa", 'e', List.of()),
      Arguments.of("abcadabcaaa", 'd', List.of(4)),
      Arguments.of("tttt", 't', List.of(0, 1, 2, 3)),
      Arguments.of("ppooooopp", 'p', List.of(0, 1, 7, 8)),
      Arguments.of("ppooooopp", 'o', List.of(2, 3, 4, 5, 6)),
      Arguments.of("ppooppoopp", 'o', List.of(2, 3, 6, 7))
    );
  }
}
