### Сколько в нижнем регистре

На вход программе подается строка. Напишите программу, которая подсчитывает количество буквенных символов в нижнем регистре.

[Источник](https://stepik.org/lesson/296416/step/11?unit=278136)

<!-- tabs: start -->
#### **Python**

```python
from string import ascii_lowercase


def count_lower(str):
    return len([c for c in str if c in ascii_lowercase])

```
#### **Test Python**

```python
from count_lower import *
import pytest


@pytest.mark.parametrize('input, expected', [
    ('abcABCD12345', 3),
    ('gggggggg1212321ABDCEFCE', 8),
    ('2376423745dhdhdPPPP', 5),
    ('1v2b3n4m5k6h7GDFGDFd', 7)
])
def test_count_lower(input, expected):
    assert count_lower(input) == expected

```

#### **Java**

```java
package string.countLower;

public class CountLower {
    public static long countLower(String text) {
        return text.chars()
                .mapToObj(i -> (char) i)
                .filter(c -> Character.isAlphabetic(c) && Character.isLowerCase(c))
                .count();
    }
}
```
#### **Test Java**

```java
package string.countLower;

import static org.junit.Assert.assertEquals;
import static string.countLower.CountLower.countLower;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class TestCountLower {

    @ParameterizedTest
    @CsvSource(value = {
            "abcABCD12345, 3",
            "gggggggg1212321ABDCEFCE, 8",
            "2376423745dhdhdPPPP, 5",
            "1v2b3n4m5k6h7GDFGDFd, 7",
    })
    void testCountLower(String input, int expected) {
        assertEquals(expected, countLower(input));
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
