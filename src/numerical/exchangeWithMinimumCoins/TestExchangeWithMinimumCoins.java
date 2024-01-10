package numerical.exchangeWithMinimumCoins;

import static numerical.exchangeWithMinimumCoins.ExchangeWithMinimumCoins.exchangeWithMinimumCoins;
import static org.junit.Assert.assertEquals;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.List;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class TestExchangeWithMinimumCoins {
    private final ByteArrayOutputStream out = new ByteArrayOutputStream();
    private final List<Integer> coins = List.of(1, 5, 10, 25);

    @BeforeEach
    void setSystemOut() {
        System.setOut(new PrintStream(out));
    }

    @ParameterizedTest
    @CsvSource(value = {
            "49, 7",
            "1, 1",
            "5, 1",
            "10, 1",
            "25, 1",
            "2111, 86",
            "4, 4",
            "100, 4",
            "499, 25",
            "9, 5"
    })
    void testExchangeWithMinimumCoins(int cash, String expected) {
        exchangeWithMinimumCoins(coins, cash);
        assertEquals(expected, out.toString().stripTrailing());
    }

    @AfterEach
    void restoreOut() {
        System.setOut(null);
    }
}