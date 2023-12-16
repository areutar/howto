package string.isGoodPassword;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.params.ParameterizedTest.ARGUMENTS_PLACEHOLDER;
import static string.isGoodPassword.IsGoodPassword.isGoodPassword;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class TestIsGoodPassword {

    @ParameterizedTest(name = ARGUMENTS_PLACEHOLDER + " is good password")
    @ValueSource(strings = { "aaAA12qqp", "AAPPqq9S", "99yyPPgg" })
    void testIsGoodPassword(String password) {
        assertTrue(isGoodPassword(password));
    }

    @ParameterizedTest(name = ARGUMENTS_PLACEHOLDER + " is not good password")
    @ValueSource(strings = { "aaaaaaaaaaaaa", "AAAAAAAAAAAAA", "734638763978653",
            "AABBccssss", "AA23423423", "dsas233232232",
            "99yyPPg", "()+_№;%:", "aaaaaaA@" })
    void testIsNotGoodPassword(String password) {
        assertFalse(isGoodPassword(password));
    }
}