package sysout.starTriangle2;

import static org.junit.Assert.assertEquals;
import static sysout.starTriangle2.StarTriangle2.starTriangle2;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.stream.Stream;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

public class TestStarTriangle2 {
    private final ByteArrayOutputStream out = new ByteArrayOutputStream();
    private static final String sep = System.lineSeparator();

    @BeforeEach
    void setSystemOut() {
        System.setOut(new PrintStream(out));
    }

    @ParameterizedTest
    @MethodSource("provideParams")
    void testStarTriangle2(int input, String expected) {
        starTriangle2(input);
        assertEquals(expected, out.toString().stripTrailing());
    }

    public static Stream<Arguments> provideParams() {
        return Stream.of(
                Arguments.of("3",
                        "*" + sep
                                + "**" + sep
                                + "*"),
                Arguments.of("5",
                        "*" + sep
                                + "**" + sep
                                + "***" + sep
                                + "**" + sep
                                + "*"),
                Arguments.of("11",
                        "*" + sep
                                + "**" + sep
                                + "***" + sep
                                + "****" + sep
                                + "*****" + sep
                                + "******" + sep
                                + "*****" + sep
                                + "****" + sep
                                + "***" + sep
                                + "**" + sep
                                + "*"));
    }

    @AfterEach
    void restoreOut() {
        System.setOut(null);
    }
}