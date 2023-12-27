package sequence.swapMinAndMax;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class SwapMinAndMax {
    public static void swapMinAndMax(String input) {
        List<Integer> numbers = Arrays.stream(input.split("\\s+"))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
        Integer mx = Collections.max(numbers);
        Integer mn = Collections.min(numbers);
        List<String> swapedNumbers = numbers.stream()
                .map(n -> {
                    if (n == mx) {
                        n = mn;
                    } else if (n == mn) {
                        n = mx;
                    }
                    return String.valueOf(n);
                })
                .collect(Collectors.toList());
        System.out.println(String.join(" ", swapedNumbers));
    }

}