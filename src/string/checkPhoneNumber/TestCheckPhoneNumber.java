package string.checkPhoneNumber;

import static org.junit.Assert.assertEquals;
import static string.checkPhoneNumber.CheckPhoneNumber.checkPhoneNumber;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class TestCheckPhoneNumber {
    @Test
    public void checkValidPrefixedNumber() {
        assertEquals(true, checkPhoneNumber("7-301-447-5820"));
    }

    @Test
    public void checkValidUnprefixedNumber() {
        assertEquals(true, checkPhoneNumber("301-447-5820"));
    }

    @ParameterizedTest
    @ValueSource(strings = { "301-4477-5820",
            "3X1-447-5820",
            "3014475820",
            "8-301-447-5820",
            "77-301-447-5820",
            "311-4A7-5820",
            "311-487-582B",
            "3A1-4M7-582B",
            "7-3A1-447-5820",
            "77-301-447-5820",
            "7-301-4BB-5820",
            "7-abc-abc-abc",
            "abc-abc-abc",
            "7-123-456-c-7890",
            "7-1234-567-890",
            "7-123-4567-890",

    })

    public void invalidNumbers(String number) {
        assertEquals(false, checkPhoneNumber(number));
    }

}