package sequence.isCorrectBrackets2;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Map;

public class IsCorrectBrackets2 {
    public static final Map<Character, Character> brackets = Map.of(
            '(', ')',
            '[', ']',
            '{', '}');

    public static void isCorrectBrackets2(String input) {
        Deque<Character> stack = new ArrayDeque<>();
        boolean result = true;
        for (int i = 0; i < input.length(); i++) {
            Character current = input.charAt(i);
            if (brackets.containsKey(current)) {
                stack.push(current);
            }
            if (brackets.containsValue(current) && (stack.isEmpty() ||
                    brackets.get(stack.pop()) != current)) {
                result = false;
                break;
            }
        }
        if (result) {
            result = stack.isEmpty();
        }
        System.out.println(result);
    }

}