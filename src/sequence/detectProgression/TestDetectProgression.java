package sequence.detectProgression;

import static org.junit.Assert.assertEquals;
import static sequence.detectProgression.DetectProgression.detectProgression;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.List;
import java.util.stream.Stream;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

public class TestDetectProgression {
    private final ByteArrayOutputStream out = new ByteArrayOutputStream();

    @BeforeEach
    void setSystemOut() {
        System.setOut(new PrintStream(out));
    }

    @ParameterizedTest
    @MethodSource("provideParams")
    void testDetectProgression(List<Integer> input, String expected) {
        detectProgression(input);
        assertEquals(expected, out.toString().stripTrailing());
    }

    private static Stream<Arguments> provideParams() {
        return Stream.of(
                Arguments.of(List.of(1, 2), "true"),
                Arguments.of(List.of(2, 1), "true"),
                Arguments.of(List.of(2, 1, 3), "true"),
                Arguments.of(List.of(0, -3, 3, -6), "true"),
                Arguments.of(List.of(18, 15, 6, 9, 12, 3, 0), "true"),
                Arguments.of(List.of(1, 2, 4), "false"),
                Arguments.of(List.of(1, 2, 3, 2), "false"),
                Arguments.of(List.of(1, 2, 3, 5), "false"),
                Arguments.of(List.of(2, 4, 8), "false"),
                Arguments.of(List.of(10, 5, 0), "true"),
                Arguments.of(List.of(1, 1, 1, 1, 1, 1, 1), "true"),
                Arguments.of(List.of(1000, 2000, 3000), "true"),
                Arguments.of(List.of(25, 125, 224), "false"));
    }

    @AfterEach
    void restoreOut() {
        System.setOut(null);
    }
}