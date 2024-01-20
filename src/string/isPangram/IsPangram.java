package string.isPangram;

public class IsPangram {
    public static void isPangram(String input) {
        boolean result = input.toUpperCase().chars()
                .filter(i -> i >= 65 && i <= 90)
                .distinct()
                .count() == 26;
        System.out.println(result);
    }

}