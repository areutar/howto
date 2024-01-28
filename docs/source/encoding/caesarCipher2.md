### Шифр Цезаря 2

На вход программе подается строка текста на английском языке, в которой нужно зашифровать все слова. Каждое слово строки следует зашифровать с помощью шифра Цезаря (циклического сдвига на длину этого слова). Строчные буквы при этом остаются строчными, а прописные – прописными. Гарантируется, что между различными словами присутствует один пробел.

[Источник](https://stepik.org/lesson/352860/step/10?unit=336821)

<!-- tabs: start -->
#### **Python**

```python
import re
from string import ascii_lowercase
from string import ascii_uppercase

ALPHABETS = [ascii_lowercase, ascii_uppercase]


def caesar_cipher2(text):
    founds = re.finditer('\w+', text)
    for found in founds:
        word = found.group()
        encoded_word = caesar_cipher_code(len(word), word)
        text = text.replace(word, encoded_word, 1)
    return text


def caesar_cipher_code(shift, text):
    result = []
    for c in text:
        alphabets = get_alphabet(c)
        if alphabets:
            alphabet = get_alphabet(c)[0]
            alphabet_index = alphabet.find(c)
            result.append(alphabet[(alphabet_index + shift) % len(alphabet)])
        else:
            result.append(c)
    return ''.join(result)


def get_alphabet(ch):
    return [alphabet for alphabet in ALPHABETS if ch in alphabet]


# text = input()
# print(caesar_cipher2(text))
```
#### **Test Python**

```python
from caesar_cipher2 import caesar_cipher2
import pytest

data = [
    ('Day, mice. "Year" is a mistake!',
        'Gdb, qmgi. "Ciev" ku b tpzahrl!'),
    ('my name is Python!',
        'oa reqi ku Veznut!'),
    ('To be, or not to be, that is the question',
        'Vq dg, qt qrw vq dg, xlex ku wkh ycmabqwv')
]


@pytest.mark.parametrize('input, expected', data)
def test_caesar_cipher2(input, expected):
    actual = caesar_cipher2(input)
    assert actual == expected
```

#### **Java**

```java
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
```
#### **Test Java**

```java
package encoding.caesarCipher2;

import static org.junit.Assert.assertEquals;
import static encoding.caesarCipher2.CaesarCipher2.caesarCipher2;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class TestCaesarCipher2 {
    private final ByteArrayOutputStream out = new ByteArrayOutputStream();

    @BeforeEach
    void setSystemOut() {
        System.setOut(new PrintStream(out));
    }

    @ParameterizedTest
    @CsvSource(value = {
            "'Day, mice. \"Year\" is a mistake!', " +
                    "'Gdb, qmgi. \"Ciev\" ku b tpzahrl!'",
            "'my name is Python!', " +
                    "'oa reqi ku Veznut!'",
            "'To be, or not to be, that is the question', " +
                    "'Vq dg, qt qrw vq dg, xlex ku wkh ycmabqwv'"

    })
    void testCaesarCipher2(String input, String expected) {
        caesarCipher2(input);
        assertEquals(expected, out.toString().stripTrailing());
    }

    @AfterEach
    void restoreOut() {
        System.setOut(null);
    }
}
```

#### **JavaScript**

```javascript

```
#### **Test JavaScript**

```javascript

```
<!-- tabs: end -->
