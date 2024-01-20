### Панграммы

Панграмма – это фраза, содержащая в себе все буквы алфавита. Напишите функцию, is_pangram(text) которая принимает в качестве аргумента строку текста на английском языке и возвращает значение True если текст является панграммой и False в противном случае.

[Источник](https://stepik.org/lesson/334152/step/10?unit=317561)

<!-- tabs: start -->
#### **Python**

```python
from string import ascii_lowercase


def is_pangram(input):
    result = sum([ch in input.lower()
                  for ch in ascii_lowercase]) == 26
    print(result)
```
#### **Test Python**

```python
from is_pangram import *
import pytest


@pytest.mark.parametrize('input, expected', [
    ('abcdefghijklmnopqrstuvwxyz', 'True'),
    ('The quick brown fox jumps over the lazy dog', 'True'),
    ('Jackdaws love my big sphinx of quartz', 'True'),
    ('The five boxing wizards jump quickly. ', 'True'),
    ('ddddddddddddddddddddddddddddddddddddddddddddddddddddddd', 'False'),
    ('abcdefghijklmnopqastuvwxyzabcdefghijklmnopq', 'False'),
    ('def test_is_pangram(input, expected, capsys):', 'False'),
    ('''def test_is_pangram(input, expected, capsys):
    is_pangram(input)
    captured = capsys.readouterr().out.strip()
    assert captured == expected''', 'False')
])
def test_is_pangram(input, expected, capsys):
    is_pangram(input)
    captured = capsys.readouterr().out.strip()
    assert captured == expected
```

#### **Java**

```java
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
```
#### **Test Java**

```java
package string.isPangram;

import static org.junit.Assert.assertEquals;
import static string.isPangram.IsPangram.isPangram;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class TestIsPangram {
    private final ByteArrayOutputStream out = new ByteArrayOutputStream();

    @BeforeEach
    void setSystemOut() {
        System.setOut(new PrintStream(out));
    }

    @ParameterizedTest
    @CsvSource(value = {
            "'abcdefghijklmnopqrstuvwxyz', 'true'",
            "'The quick brown fox jumps over the lazy dog', 'true'",
            "'Jackdaws love my big sphinx of quartz', 'true'",
            "'The five boxing wizards jump quickly. ', 'true'",
            "'ddddddddddddddddddddddddddddddddddddddddddddddddddddddd', 'false'",
            "'abcdefghijklmnopqastuvwxyzabcdefghijklmnopq', 'false'",
            "'def test_is_pangram(input, expected, capsys):', 'false'",
            "' void testIsPangram(String input, String expected) {\r\n" + //
                    "        isPangram(input);\r\n" + //
                    "        assertEquals(expected, out.toString().stripTrailing());\r\n" + //
                    "    }', 'false'"
    })
    void testIsPangram(String input, String expected) {
        isPangram(input);
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

[Ещё по теме:](https://ru.wikipedia.org/wiki/%D0%9F%D0%B0%D0%BD%D0%B3%D1%80%D0%B0%D0%BC%D0%BC%D0%B0)
