package sequence.allElementsAreTheSame;

import static org.junit.Assert.assertEquals;
import static sequence.allElementsAreTheSame.AllElementsAreTheSame.allElementsAreTheSame;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class TestAllElementsAreTheSame {
    private final ByteArrayOutputStream out = new ByteArrayOutputStream();

    @BeforeEach
    void setSystemOut() {
        System.setOut(new PrintStream(out));
    }

    @ParameterizedTest
    @CsvSource(value = {
            "'11111', 'YES'",
            "'', 'YES'",
            "'11112111', 'NO'",
            "'1', 'YES'",
            "'77', 'YES'",
            "'56', 'NO'",
            "'999', 'YES'",
            "'899', 'NO'",
            "'989', 'NO'",
            "'998', 'NO'",
            "'666666666666666', 'YES'",
            "'6666667666666', 'NO'",
            "'177777777777777', 'NO'",
            "'77777777777777771', 'NO'",
            "'9999999999999999999999999999', 'YES'",
            "'1211111', 'NO'",
            "'1237564', 'NO'",
            "'231', 'NO'",
            "'132', 'NO'",
            "'1000000', 'NO'"
    })
    void testAllElementsAreTheSame(String input, String expected) {
        allElementsAreTheSame(input);
        assertEquals(expected, out.toString().stripTrailing());
    }

    @AfterEach
    void restoreOut() {
        System.setOut(null);
    }
}