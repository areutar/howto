package encoding.caesarCipher;

import java.util.List;
import java.util.Optional;

public class CaesarCipher {
    public static final String ALPHABET_RU = "АБВГДЕЖЗИЙКЛМНОПРСТУФХЦЧШЩЪЫЬЭЮЯ";
    public static final String ALPHABET_RU_LOW = "абвгдежзийклмнопрстуфхцчшщъыьэюя";
    public static final String ALPHABET_EN = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    public static final String ALPHABET_EN_LOW = "abcdefghijklmnopqrstuvwxyz";
    public static List<String> alphabets = List.of(
            ALPHABET_EN, ALPHABET_EN_LOW, ALPHABET_RU, ALPHABET_RU_LOW);

    public static void caesarCipher(int shift, String text) {
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
        System.out.println(builder.toString());
    }

    public static Optional<String> getAlphabet(char ch) {
        return alphabets.stream()
                .filter(alphabet -> alphabet.indexOf(ch) >= 0)
                .findFirst();
    }
}