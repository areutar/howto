package string.checkCapitalized;

import java.util.Arrays;

public class CheckCapitalized {
    public static boolean checkCapitalized(String text) {
            return Arrays.stream(text.split(" "))
                .allMatch(s -> Character.isUpperCase(s.charAt(0)));
          }
}