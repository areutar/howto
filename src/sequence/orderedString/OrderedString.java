package sequence.orderedString;

import java.util.Comparator;
import java.util.stream.Collectors;

public class OrderedString {
    public static void orderedString(String input) {
        if (input.length() <= 1) {
            System.out.println("true");
        }
        String sortedString = sortString(input);
        System.out.println(input.equals(sortedString));
    }

    public static String sortString(String input) {
        return input.chars()
                .mapToObj(i -> (char) i)
                .sorted(Comparator.reverseOrder())
                .map(String::valueOf)
                .collect(Collectors.joining());
    }
}