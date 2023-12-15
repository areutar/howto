package string.getSumOfDigits;

import java.util.Arrays;

public class GetSumOfDigits {
    public static int getSumOfDigits(String input) {
        return Arrays.stream(input.split(""))
                .map(Integer::parseInt)
                .mapToInt(Integer::intValue)
                .sum();
    }

}