package string.everyThird;

import java.util.stream.IntStream;

public class EveryThird {
    public static String everyThird(String str) {
        return IntStream.range(0, str.length())
                .filter(i -> i % 3 != 0)
                .mapToObj(str::charAt)
                .collect(StringBuilder::new, StringBuilder::append,
                        StringBuilder::append)
                .toString();
    }
}
