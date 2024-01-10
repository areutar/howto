package numerical.isValidTriangle;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class IsValidTriangle {
    public static void isValidTriangle(String input) {
        List<Integer> sides = Arrays.stream(input.split("\\s+"))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
        int max = sides.stream().max(Comparator.naturalOrder()).get();
        int sum = sides.stream()
                .mapToInt(Integer::intValue)
                .sum();
        System.out.println(sum > 2 * max);
    }

}