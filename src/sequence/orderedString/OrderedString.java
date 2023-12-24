package sequence.orderedString;

import java.util.Comparator;
import java.util.stream.Collectors;

public class OrderedString {
    public static boolean orderedString(String input) {
        if (input.length() <= 1) {
            return true;
        }
        return input.equals(sortString(input));
    }

    public static String sortString(String input) {
        return input.chars()
                .mapToObj(i -> (char) i)
                .sorted(Comparator.reverseOrder())
                .map(String::valueOf)
                .collect(Collectors.joining());
    }
}