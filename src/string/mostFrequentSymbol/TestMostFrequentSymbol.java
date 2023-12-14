package string.mostFrequentSymbol;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class TestMostFrequentSymbol {
    @ParameterizedTest
    @CsvSource(value = {
            "aaaabbc, a",
            "abaabbcccc, c",
            "pppppppppppppppppppppuuuuuuuuuuuuuuuuuuuuuuqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqq, q",
            "asasasasasppppppppppppppppppppppppppqw, p",
            "aaaAAAA, A",
            "привет питонннннннннннннннНННН, н",
            "11111111111111111111111111111111111111, 1",
            "jfnmdbsdfnsjfqenfdssjdfhsdjlkpppppppppppppppp"
                    + "ppgggggxxzzzssswwwwwwwwwwwwwwwwwwfgdfxdfg, w",
    })
    void testGetMostFrequentSymbol() {

    }
}
