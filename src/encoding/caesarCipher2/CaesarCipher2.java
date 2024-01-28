package encoding.caesarCipher2;

import java.util.List;
import java.util.Optional;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CaesarCipher2 {
    private static final Pattern pattern = Pattern.compile("\\w+");
    public static final String ALPHABET_EN = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    public static final String ALPHABET_EN_LOW = "abcdefghijklmnopqrstuvwxyz";
    public static List<String> alphabets = List.of(
            ALPHABET_EN, ALPHABET_EN_LOW);

    public static void main(String[] args) {
        String input = "Day, mice. \"Year\" is a mistake!";
        caesarCipher2(input);
    }

    public static void caesarCipher2(String input) {
        Matcher matcher = pattern.matcher(input);
        while (matcher.find()) {
            String found = matcher.group();
            String replacement = caesarCipher(found.length(), found);
            input = input.replaceFirst(found, replacement);
        }
        System.out.println(input);
    }

    public static String caesarCipher(int shift, String text) {
        StringBuilder builder = new StringBuilder();
        text.chars()
                .mapToObj(i -> (char) i)
                .map(ch -> {
                    Optional<String> optAlph = getAlphabet(ch);
                    if (!optAlph.isPresent()) {
                        return ch;
                    }
                    String alphabet = optAlph.get();
                    int indexCh = alphabet.indexOf(ch);
                    int length = alphabet.length();
                    int newIndex = (shift % length + length + indexCh) % length;
                    return alphabet.charAt(newIndex);
                })
                .forEach(ch -> builder.append(ch));
        return builder.toString();
    }

    public static Optional<String> getAlphabet(char ch) {
        return alphabets.stream()
                .filter(alphabet -> alphabet.indexOf(ch) >= 0)
                .findFirst();
    }
}
