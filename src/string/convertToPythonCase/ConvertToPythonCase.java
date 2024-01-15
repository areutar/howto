package string.convertToPythonCase;

import java.util.stream.Collectors;

public class ConvertToPythonCase {
    public static void convertToPythonCase(String input) {
        String result = input.chars()
                .mapToObj(i -> (char) i)
                .map(ch -> Character.isUpperCase(ch)
                        ? "_" + String.valueOf(ch).toLowerCase()
                        : String.valueOf(ch))
                .collect(Collectors.joining());

        if (result.startsWith("_")) {
            result = result.substring(1);
        }
        System.out.println(result);
    }

}