### Самое длинное слово

На вход программе подается строка текста. Напишите программу, использующую списочное выражение, которая находит длину самого длинного слова.

[Источник](https://stepik.org/lesson/327221/step/5?unit=310520)

<!-- tabs: start -->
#### **Python**

```python
def longest_word(input):
    return len(max(input.split(), key=len))
```
#### **Test Python**

```python
from longest_word import *
import pytest


@pytest.mark.parametrize('input, expected', [
    ('проспал почти всю ночь', 7),
    ('sss fffffff qqqqqq aaaaaaaaaaaaaaaaaaaa qq', 20),
    ('qwerty', 6),
    ('python is awesome', 7),
    ('qqqqqqqqqqqqqqqqqqqqqqqq pppppppppppp', 24),
])
def test_longest_word(input, expected):
    assert longest_word(input) == expected
```

#### **Java**

```java
package string.longestWord;

import java.util.Arrays;

public class LongestWord {
    public static int longestWord(String input) {
        return Arrays.stream(input.split("\\s+"))
                .mapToInt(String::length)
                .max().getAsInt();
    }
}
```
#### **Test Java**

```java
package string.longestWord;

import static org.junit.Assert.assertEquals;
import static string.longestWord.LongestWord.longestWord;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class TestLongestWord {

    @ParameterizedTest
    @CsvSource(value = {
            "проспал почти всю ночь, 7",
            "s ss fffffff qqqqqq aaaaaaaaaaaaaaaaaaaa qq, 20",
            "qwerty, 6",
            "python is awesome, 7",
            "qqqqqqqqqqqqqqqqqqqqqqqq pppppppppppp, 24"
    })

    void testLongestWord(String input, int expected) {
        assertEquals(expected, longestWord(input));
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
