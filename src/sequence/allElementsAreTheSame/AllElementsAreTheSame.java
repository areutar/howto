package sequence.allElementsAreTheSame;

public class AllElementsAreTheSame {
    public static void allElementsAreTheSame(String input) {
        String result = "YES";
        if (input.length() > 1) {
            char firstChar = input.charAt(0);
            if (input.chars()
                    .anyMatch(c -> c != firstChar)) {
                result = "NO";
            }
        }
        System.out.println(result);
    }
}