package string.isGoodPassword;

public class IsGoodPassword {
    public static boolean isGoodPassword(String pas) {
        boolean hasDigit = pas.chars()
                .mapToObj(i -> (char) i)
                .anyMatch(c -> Character.isDigit(c));
        boolean hasLower = pas.chars()
                .mapToObj(i -> (char) i)
                .anyMatch(c -> Character.isLowerCase(c));
        boolean hasUpper = pas.chars()
                .mapToObj(i -> (char) i)
                .anyMatch(c -> Character.isUpperCase(c));
        return pas.length() >= 8 && hasDigit && hasLower && hasUpper;
    }

}