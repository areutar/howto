package encoding.caesarCipher2;

import static org.junit.Assert.assertEquals;
import static encoding.caesarCipher2.CaesarCipher2.caesarCipher2;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class TestCaesarCipher2 {
    private final ByteArrayOutputStream out = new ByteArrayOutputStream();

    @BeforeEach
    void setSystemOut() {
        System.setOut(new PrintStream(out));
    }

    @ParameterizedTest
    @CsvSource(value = {
            "'Day, mice. \"Year\" is a mistake!', " +
                    "'Gdb, qmgi. \"Ciev\" ku b tpzahrl!'",
            "'my name is Python!', " +
                    "'oa reqi ku Veznut!'",
            "'To be, or not to be, that is the question', " +
                    "'Vq dg, qt qrw vq dg, xlex ku wkh ycmabqwv'"

    })
    void testCaesarCipher2(String input, String expected) {
        caesarCipher2(input);
        assertEquals(expected, out.toString().stripTrailing());
    }

    @AfterEach
    void restoreOut() {
        System.setOut(null);
    }
}