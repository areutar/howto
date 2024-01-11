package simple.isCorrectBrackets;

public class IsCorrectBrackets {
    public static void isCorrectBrackets(String input) {
        int count = 0;
        for (Character ch : input.toCharArray()) {
            if (ch == '(') {
                count++;
            }
            if (ch == ')') {
                count--;
            }
            if (count < 0) {
                break;
            }
        }
        System.out.println(count == 0);
    }

}