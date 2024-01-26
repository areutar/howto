### Шифр Цезаря

Описание проекта: требуется написать программу, способную шифровать и дешифровать текст в соответствии с алгоритмом Цезаря. Она должна запрашивать у пользователя следующие данные:
- направление: шифрование или дешифрование;
- язык алфавита: русский или английский;
- шаг сдвига (со сдвигом вправо).

**Примечание 1.** Считайте, что в русском языке 32 буквы (буква ё отсутствует).

**Примечание 2.** Неалфавитные символы — знаки препинания, пробелы, цифры — не меняются.

**Примечание 3.** Сохраните регистр символов. Например, текст: "Умом Россию не понять" при сдвиге на одну позицию вправо будет преобразован в: "Фнпн Спттйя ож рпоауэ".

[Источник](https://stepik.org/lesson/352860/step/4?unit=336821)

<!-- tabs: start -->
#### **Python**

```python
ALPHABET_RU = 'АБВГДЕЖЗИЙКЛМНОПРСТУФХЦЧШЩЪЫЬЭЮЯ'
ALPHABET_RU_LOW = 'абвгдежзийклмнопрстуфхцчшщъыьэюя'
ALPHABET_EN = 'ABCDEFGHIJKLMNOPQRSTUVWXYZ'
ALPHABET_EN_LOW = 'abcdefghijklmnopqrstuvwxyz'
ALPHABETS = [ALPHABET_EN, ALPHABET_EN_LOW, ALPHABET_RU, ALPHABET_RU_LOW]
DIRECTIONS = ['вперёд', 'назад']
TRY_AGAIN_MESSAGE = 'Попробуйте ещё раз!\n'
DIRECTIONS_MAP = {'вперёд': 1, 'назад': -1}


def caesar_cipher_encode():
    direction = provide_direction()
    shift = provide_shift(direction)
    text = provide_text()
    return caesar_cipher_code(shift, text)


def caesar_cipher_code(shift, text):
    result = []
    for c in text:
        alphabets = get_alhpabet(c)
        if not alphabets:
            result.append(c)
        else:
            alphabet = get_alhpabet(c)[0]
            alph_index = alphabet.find(c)
            result.append(alphabet[(alph_index + shift) % len(alphabet)])
    return ''.join(result)


def get_alhpabet(ch):
    return [alphbt for alphbt in ALPHABETS if ch in alphbt]


def provide_text():
    return list(input('\nВведите сообщение:\n'))


def provide_direction():
    while True:
        direction = input(
            'Введите направление сдвига(вперёд/назад)\n').strip()
        if direction in DIRECTIONS:
            print()
            return DIRECTIONS_MAP[direction]
        else:
            print('Подходят только слова "вперёд" или "назад"')
            print(TRY_AGAIN_MESSAGE)


def provide_shift(direction):
    while True:
        try:
            shift = int(input('На сколько букв сдвинуть?\n'))
            if shift < 0:
                raise ValueError
            return shift * direction
        except ValueError:
            print('Нужно ввести целое положительное число')
            print(TRY_AGAIN_MESSAGE)
```
#### **Test Python**

```python
from caesar_cipher import caesar_cipher_code
import pytest


@pytest.mark.parametrize('shift, text, expected', [
    (10, 'Блажен, кто верует, тепло ему на свете!',
     'Лхкрпч, фьш мпъэпь, ьпщхш пцэ чк ымпьп!'),
    (17, 'To be, or not to be, that is the question!',
     'Kf sv, fi efk kf sv, kyrk zj kyv hlvjkzfe!'),
    (-7, 'Шсъцхр щмчжмщ йшм, нмтзж йшм лхшщзщг.',
     'Скупой теряет все, желая все достать.'),
    (-25, 'Sgd fqzrr hr zkvzxr fqddmdq nm sgd nsgdq rhcd ne sgd edmbd.',
     'The grass is always greener on the other side of the fence.'),
    (2, 'AbcАбвxyzэюя', 'CdeВгдzabяаб')
])
def test_caesar_cipher_code(shift, text, expected):
    actual = caesar_cipher_code(shift, text)
    assert actual == expected
```

#### **Java**

```java
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
```
#### **Test Java**

```java
package encoding.caesarCipher;

import static encoding.caesarCipher.CaesarCipher.caesarCipher;
import static org.junit.Assert.assertEquals;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.stream.Stream;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

public class TestCaesarCipher {
    private final ByteArrayOutputStream out = new ByteArrayOutputStream();

    @BeforeEach
    void setSystemOut() {
        System.setOut(new PrintStream(out));
    }

    @ParameterizedTest
    @MethodSource("provideParams")

    void testCaesarCipher(int shift, String text, String expected) {
        caesarCipher(shift, text);
        assertEquals(expected, out.toString().stripTrailing());
    }

    public static Stream<Arguments> provideParams() {
        return Stream.of(
                Arguments.of(10,
                        "Блажен, кто верует, тепло ему на свете!",
                        "Лхкрпч, фьш мпъэпь, ьпщхш пцэ чк ымпьп!"),
                Arguments.of(17,
                        "To be, or not to be, that is the question!",
                        "Kf sv, fi efk kf sv, kyrk zj kyv hlvjkzfe!"),
                Arguments.of(-7,
                        "Шсъцхр щмчжмщ йшм, нмтзж йшм лхшщзщг.",
                        "Скупой теряет все, желая все достать."),
                Arguments.of(-25,
                        "Sgd fqzrr hr zkvzxr fqddmdq nm sgd nsgdq rhcd ne sgd edmbd.",
                        "The grass is always greener on the other side of the fence."),
                Arguments.of(2,
                        "AbcАбвxyzэюя",
                        "CdeВгдzabяаб"));
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

[Ещё по теме:](https://ru.wikipedia.org/wiki/%D0%A8%D0%B8%D1%84%D1%80_%D0%A6%D0%B5%D0%B7%D0%B0%D1%80%D1%8F)
