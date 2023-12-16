package string.checkPhoneNumber;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class CheckPhoneNumber {
    public static final String PREFIX = "7";
    public static final String TOKENS_DELIMITER = "-";

    public static boolean checkPhoneNumber(String input) {
        if (input.startsWith(PREFIX + TOKENS_DELIMITER)) {
            input = input.substring(2);
        }
        List<String> numbers = Arrays.asList(input.split(TOKENS_DELIMITER));
        List<Integer> lengths = numbers.stream()
                .map(String::length)
                .collect(Collectors.toList());
        boolean isDecimal = numbers.stream()
                .flatMap(str -> str.chars().mapToObj(i -> (char) i))
                .allMatch(Character::isDigit);
        return isDecimal && lengths.equals(List.of(3, 3, 4));
    }

}