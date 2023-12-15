package string.countLower;

public class CountLower {
    public static long countLower(String text) {
        return text.chars()
                .mapToObj(i -> (char) i)
                .filter(c -> Character.isAlphabetic(c) && Character.isLowerCase(c))
                .count();
    }
}