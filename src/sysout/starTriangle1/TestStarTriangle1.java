package sysout.starTriangle1;

import static org.junit.Assert.assertEquals;
import static sysout.starTriangle1.StarTriangle1.starTriangle1;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.stream.Stream;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

public class TestStarTriangle1 {
    private final ByteArrayOutputStream out = new ByteArrayOutputStream();
    private static final String sep = System.lineSeparator();

    @BeforeEach
    void setSystemOut() {
        System.setOut(new PrintStream(out));
    }

    @ParameterizedTest
    @MethodSource("provideParams")
    void testStarTriangle1(int number, String expected) {
        starTriangle1(number);
        assertEquals(expected, out.toString());
    }

    public static Stream<Arguments> provideParams() {
        return Stream.of(
                Arguments.of(
                        1, "*" + sep),
                Arguments.of(
                        2,
                        " *" + sep
                                + "***" + sep),
                Arguments.of(
                        8,
                        "       *" + sep
                                + "      ***" + sep
                                + "     *****" + sep
                                + "    *******" + sep
                                + "   *********" + sep
                                + "  ***********" + sep
                                + " *************" + sep
                                + "***************" + sep));
    }

    @AfterEach
    void restoreOut() {
        System.setOut(null);
    }
}