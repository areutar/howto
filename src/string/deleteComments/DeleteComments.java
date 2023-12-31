package string.deleteComments;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class DeleteComments {
    public static final String sep = System.lineSeparator();

    public static String deleteComments(String input) {
        String commentsSigns = "//";
        List<String> words = Arrays.stream(input.split(sep))
                .map(line -> {
                    if (line.contains(commentsSigns)) {
                        line = line.substring(0, line.indexOf(commentsSigns));
                    }
                    return line.stripTrailing();
                })
                .collect(Collectors.toList());
        return String.join(sep, words);
    }

}