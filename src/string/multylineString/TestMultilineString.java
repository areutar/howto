package string.multylineString;

import static org.junit.Assert.assertEquals;
import static string.multylineString.MultilineString.*;

import org.junit.Test;

public class TestMultilineString {
    @Test
    public void testConcatenateStrings() {
        assertEquals(text, textWithConcatenation);
    }
    @Test
    public void testJoinStrings() {
        assertEquals(text, textWithStringJoin);
    }
}
