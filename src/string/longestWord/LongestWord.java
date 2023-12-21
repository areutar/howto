package string.longestWord;

import java.util.Arrays;

public class LongestWord {
    public static int longestWord(String input) {
        return Arrays.stream(input.split("\\s+"))
                .mapToInt(String::length)
                .max().getAsInt();
    }
}