package string.countEqualNeighbours;

import java.util.stream.IntStream;

public class CountEqualNeighbours {
    public static int countEqualNeighbours(String str) {
        return (int) IntStream.range(0, str.length() - 1)
                .filter(i -> str.charAt(i) == str.charAt(i + 1))
                .count();
    }

}