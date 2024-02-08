package numerical.flipBit;

import static numerical.flipBit.FlipBit.flipBit;
import static org.junit.Assert.assertEquals;

import java.util.stream.Stream;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

public class TestFlipBit {

    @ParameterizedTest
    @MethodSource("provideParams")

    void testFlipBit(int value, int bitIndex, int expected) {
        int actual = flipBit(value, bitIndex);
        assertEquals(expected, actual);
    }

    public static Stream<Arguments> provideParams() {
        return Stream.of(
                Arguments.of(0, 1, 1),
                Arguments.of(1, 1, 0),
                Arguments.of(0b11, 1, 0b10),
                Arguments.of(0b10, 1, 0b11),
                Arguments.of(0b10, 2, 0),
                Arguments.of(0b11111111, 4, 0b11110111));
    }
}