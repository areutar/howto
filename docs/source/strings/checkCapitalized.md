### Проверка заглавных букв

На вход программе подается строка состоящая из имён и фамилий людей, разделенных пробелом. Напишите программу, которая проверяет, что все слова начинаются с заглавной буквы.

[Источник](https://stepik.org/lesson/296416/step/8?thread=solutions&unit=278136)

<!-- tabs: start -->
#### **Python**

```python
def check_capitalized(input):
    return input == input.title()
```
#### **Test Python**

```python
from check_capitalized import *
import pytest


@pytest.mark.parametrize('input, expected', [
    ('chris alan', False),
    ('Chris alan', False),
    ('chris Alan', False),
    ('Chris Alan', True)
])
def test_check_capitalized(input, expected):
    assert check_capitalized(input) == expected
```

#### **Java**

```java
package string.checkCapitalized;

import java.util.Arrays;

public class CheckCapitalized {
    public static boolean checkCapitalized(String text) {
            return Arrays.stream(text.split(" "))
                .allMatch(s -> Character.isUpperCase(s.charAt(0)));
          }
}
```
#### **Test Java**

```java
package string.checkCapitalized;

import static org.junit.Assert.assertEquals;
import static string.checkCapitalized.CheckCapitalized.checkCapitalized;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class TestCheckCapitalized {

    @ParameterizedTest
    @CsvSource(value = {
            "chris alan, false",
            "Chris Alan, true",
            "chris Alan, false",
            "Chris alan, false",
    })
    void testCheckCapitalized(String input, boolean expected) {
        assertEquals(expected, checkCapitalized(input));
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
