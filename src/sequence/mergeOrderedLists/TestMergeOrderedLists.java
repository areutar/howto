package sequence.mergeOrderedLists;

import static org.junit.Assert.assertEquals;
import java.util.List;
import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import static sequence.mergeOrderedLists.MergeOrderedLists.*;

public class TestMergeOrderedLists {
    @ParameterizedTest
    @MethodSource("provideParams")
    void testMergeLists(List<Integer> list1,
            List<Integer> list2, List<Integer> expected) {
        List<Integer> actual = mergeOrderedLists(list1, list2);
        assertEquals(expected, actual);
    }

    private static Stream<Arguments> provideParams() {
        return Stream.of(
                Arguments.of(List.of(1, 2, 3),
                        List.of(5, 6, 7, 8),
                        List.of(1, 2, 3, 5, 6, 7, 8)),
                Arguments.of(List.of(1, 7, 10, 16),
                        List.of(5, 6, 13, 20),
                        List.of(1, 5, 6, 7, 10, 13, 16, 20)),
                Arguments.of(List.of(1),
                        List.of(2),
                        List.of(1, 2)),
                Arguments.of(List.of(1, 2),
                        List.of(1, 3),
                        List.of(1, 1, 2, 3)),
                Arguments.of(List.of(10, 11, 12),
                        List.of(1, 2, 3),
                        List.of(1, 2, 3, 10, 11, 12)),
                Arguments.of(List.of(1),
                        List.of(),
                        List.of(1)),
                Arguments.of(List.of(),
                        List.of(),
                        List.of()),
                Arguments.of(List.of(1),
                        List.of(1),
                        List.of(1, 1)));
    }
}
