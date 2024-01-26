package encoding.caesarCipher;

import static encoding.caesarCipher.CaesarCipher.caesarCipher;
import static org.junit.Assert.assertEquals;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.stream.Stream;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

public class TestCaesarCipher {
    private final ByteArrayOutputStream out = new ByteArrayOutputStream();

    @BeforeEach
    void setSystemOut() {
        System.setOut(new PrintStream(out));
    }

    @ParameterizedTest
    @MethodSource("provideParams")

    void testCaesarCipher(int shift, String text, String expected) {
        caesarCipher(shift, text);
        assertEquals(expected, out.toString().stripTrailing());
    }

    public static Stream<Arguments> provideParams() {
        return Stream.of(
                Arguments.of(10,
                        "Блажен, кто верует, тепло ему на свете!",
                        "Лхкрпч, фьш мпъэпь, ьпщхш пцэ чк ымпьп!"),
                Arguments.of(17,
                        "To be, or not to be, that is the question!",
                        "Kf sv, fi efk kf sv, kyrk zj kyv hlvjkzfe!"),
                Arguments.of(-7,
                        "Шсъцхр щмчжмщ йшм, нмтзж йшм лхшщзщг.",
                        "Скупой теряет все, желая все достать."),
                Arguments.of(-25,
                        "Sgd fqzrr hr zkvzxr fqddmdq nm sgd nsgdq rhcd ne sgd edmbd.",
                        "The grass is always greener on the other side of the fence."),
                Arguments.of(2,
                        "AbcАбвxyzэюя",
                        "CdeВгдzabяаб"));
    }

    @AfterEach
    void restoreOut() {
        System.setOut(null);
    }
}