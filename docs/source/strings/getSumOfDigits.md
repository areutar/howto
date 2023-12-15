### Сумма цифр строки

На вход программе подается одна строка состоящая из цифр. Напишите программу, которая считает сумму цифр данной строки.

[Источник](https://stepik.org/lesson/284101/step/10?thread=solutions&unit=265440)

<!-- tabs: start -->
#### **Python**

```python
def get_sum_of_digits(input):
    return sum([int(i) for i in input])
```

#### **Test Python**

```python
from get_sum_of_digits import *
import pytest


@pytest.mark.parametrize('input, expected', [
    ('2514', 12),
    ('12', 3),
    ('12345', 15),
    ('7777777777', 70)
])
def test_get_sum_of_digits(input, expected):
    assert get_sum_of_digits(input) == expected

```

#### **Java**

```java
package string.getSumOfDigits;

import java.util.Arrays;

public class GetSumOfDigits {
    public static int getSumOfDigits(String input) {
        return Arrays.stream(input.split(""))
                .map(Integer::parseInt)
                .mapToInt(Integer::intValue)
                .sum();
    }

}
```
#### **Test Java**

```java
package string.getSumOfDigits;

import static org.junit.Assert.assertEquals;
import static string.getSumOfDigits.GetSumOfDigits.getSumOfDigits;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class TestGetSumOfDigits {

    @ParameterizedTest
    @CsvSource(value = {
            "2514, 12",
            "12, 3",
            "12345, 15",
            "7777777777, 70",
    })
    void testGetSumOfDigits(String input, int expected) {
        assertEquals(expected, getSumOfDigits(input));
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
