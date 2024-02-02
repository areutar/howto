package numerical.BOH;

import static org.junit.Assert.assertEquals;
import static numerical.BOH.BOH.boh;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.stream.Stream;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

public class TestBOH {
    private final ByteArrayOutputStream out = new ByteArrayOutputStream();
    private static final String sep = System.lineSeparator();

    @BeforeEach
    void setSystemOut() {
        System.setOut(new PrintStream(out));
    }

    @ParameterizedTest
    @MethodSource("provideParams")
    void testBOH(String input, String expected) {
        boh(input);
        assertEquals(expected, out.toString());
    }

    public static Stream<Arguments> provideParams() {
        return Stream.of(
                Arguments.of(
                        "10",
                        String.join(
                                sep, "1010", "12", "A") + sep),
                Arguments.of(
                        "128",
                        String.join(
                                sep, "10000000", "200", "80") + sep),
                Arguments.of(
                        "150",
                        String.join(
                                sep, "10010110", "226", "96") + sep),
                Arguments.of(
                        "18765",
                        String.join(
                                sep, "100100101001101", "44515", "494D") + sep));
    }

    @AfterEach
    void restoreOut() {
        System.setOut(null);
    }
}