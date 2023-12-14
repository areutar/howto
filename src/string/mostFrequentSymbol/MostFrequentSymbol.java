package string.mostFrequentSymbol;

import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class MostFrequentSymbol {
    public static char getMostFrequentSymbol(String str) {
        List<Character> strList = str.chars()
                .mapToObj(i -> (char) i)
                .collect(Collectors.toList());
        Map<Character, Integer> map = strList.stream()
                .collect(Collectors.toMap(
                        Function.identity(), c -> 1, (c1, c2) -> c1 + c2));
        return map.keySet().stream()
                .max((c1, c2) -> {
                    int fr = map.get(c1) - map.get(c2);
                    int in = str.lastIndexOf(c1) - str.lastIndexOf(c2);
                    return fr == 0 ? in : fr;
                }).get();
    }

}