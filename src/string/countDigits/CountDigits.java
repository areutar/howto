package string.countDigits;

public class CountDigits {
    public static int countDigits(String str) {
        return (int) str.chars()
                .filter(Character::isDigit)
                .count();
    }
}
