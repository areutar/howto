package string.getInitials;

import java.util.Arrays;
import java.util.stream.Collectors;

public class GetInitials {

    public static String getInitials(String input) {
    return Arrays.stream(input.split("\\s"))
    .map(s -> s.charAt(0) + ".")
    .collect(Collectors.joining());
  }
}