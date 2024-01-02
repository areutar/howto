package string.makingSlices;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.stream.Stream;

import org.junit.Test;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

public class TestMakingSlices {
    private static final String sep = System.lineSeparator();
    private final ByteArrayOutputStream out = new ByteArrayOutputStream();

    @BeforeEach
    void setSystemOut() {
        System.setOut(new PrintStream(out));
    }

    @ParameterizedTest
    @MethodSource("provideParams")
    void testMakingSlices(String input, String expected) {
        MakingSlices makingSlices = new MakingSlices(input);
        makingSlices.makingSlices();
        assertEquals(expected.stripTrailing(), out.toString().stripTrailing());
    }

    public static Stream<Arguments> provideParams() {
        return Stream.of(
                Arguments.of("Parametr",
                        "r" + sep
                                + "t" + sep
                                + "Param" + sep
                                + "Parame" + sep
                                + "Prmt" + sep
                                + "Pat" + sep
                                + "aaer" + sep
                                + "rtemaraP" + sep
                                + "reaa" + sep
                                + "rma" + sep
                                + "a" + sep
                                + "r" + sep
                                + "P" + sep
                                + "Pa" + sep
                                + "Paramet" + sep
                                + "arametr" + sep
                                + "aP" + sep
                                + "a" + sep
                                + "a" + sep
                                + "P"
                                ));
    }

    @AfterEach
    void restoreOut() {
        System.setOut(null);
    }


}