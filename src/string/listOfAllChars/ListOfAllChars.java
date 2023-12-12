package string.listOfAllChars;

import java.util.List;
import java.util.stream.Collectors;

public class ListOfAllChars {
    public static List<Character> listOfAllChars(
            List<String> strings) {
        return strings.stream()
                .flatMap(str -> str.chars()
                        .mapToObj(i -> (char) i))
                .collect(Collectors.toList());
    }

}
