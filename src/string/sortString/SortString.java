package string.sortString;

import java.util.stream.Collectors;

public class SortString {
    public static String sortString(String input) {
        return input.chars()
                .sorted()
                .mapToObj(i -> (char) i)
                .map(String::valueOf)
                .collect(Collectors.joining());
    }

}