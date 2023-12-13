### Количество цифр

Напишите программу, которая подсчитывает количество цифр в данной строке.

[Источник](https://stepik.org/lesson/303083/step/11?unit=284990)

<!-- tabs: start -->
#### **Python**

```python
def count_digits(str):
    return len([c for c in str if c.isdigit()])
```
#### **Test Python**

```python
from count_digits import *
import pytest


@pytest.mark.parametrize("input, expected",
                         [('nezabud dl-6', 1),
                          ('l33t 3301', 6),
                          ('1029384756aaa1234567890', 20),
                          ('jehfkjshfkjsdk90909090', 8)],
                         )
def test_count_digits(input, expected):
    assert count_digits(input) == expected

```

#### **Java**

```java
package string.countDigits;

public class CountDigits {
    public static int countDigits(String str) {
        return (int) str.chars()
                .filter(Character::isDigit)
                .count();
    }
}

```
#### **Test Java**

```java
package string.countDigits;

import static org.junit.Assert.assertEquals;
import static string.countDigits.CountDigits.countDigits;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class TestCountDigits {
    @ParameterizedTest
    @CsvSource(value = {
            "nezabud dl-6, 1",
            "l33t 3301, 6",
            "1029384756aaa1234567890, 20",
            "jehfkjshfkjsdk90909090, 8"
    })
    void testCountDigits(String input, int expected) {
        assertEquals(expected, countDigits(input));
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
