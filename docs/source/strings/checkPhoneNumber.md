### Валидация телефонного номера

На вход программе подается строка текста. Напишите программу, которая определяет, является ли введенная строка корректным телефонным номером. Строка текста является корректным телефонным номером, если она имеет формат:
    abc-def-hijk или
    7-abc-def-hijk (буквы являются цифрами)

[Источник](https://stepik.org/lesson/327221/step/4?unit=310520)

<!-- tabs: start -->
#### **Python**

```python
PREFIX = '7'
TOKENS_DELIMITER = '-'


def check_number(number):
    if str(number).startswith(PREFIX + TOKENS_DELIMITER):
        number = number[2:]
    return check_unprefixed_number(number)


def check_unprefixed_number(number):
    tokens = [n for n in number.split(TOKENS_DELIMITER)]
    lengths = [len(n) for n in tokens]
    decimals = [n for n in tokens if n.isdecimal()]
    return lengths == [3, 3, 4] and len(decimals) == 3
```
#### **Test Python**

```python
from check_phone_number import *
import pytest

data = [
    ('7-301-447-5820', True),
    ('301-447-5820', True),
    ('301-4477-5820', False),
    ('3X1-447-5820', False),
    ('3014475820', False),

    ('8-301-447-5820', False),
    ('77-301-447-5820', False),
    ('311-4A7-5820', False),
    ('311-487-582B', False),
    ('3A1-4M7-582B', False),

    ('7-3A1-447-5820', False),
    ('77-301-447-5820', False),
    ('7-301-4BB-5820', False),
    ('7-abc-abc-abc', False),
    ('abc-abc-abc', False),

    ('7-123-456-c-7890', False),
    ('7-1234-567-890', False),
    ('7-123-4567-890', False),
]


@pytest.mark.parametrize('input, expected', data)
def test_check_phone_number(input, expected):
    assert check_number(input) == expected
```

#### **Java**

```java
package string.checkPhoneNumber;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class CheckPhoneNumber {
    public static final String PREFIX = "7";
    public static final String TOKENS_DELIMITER = "-";

    public static boolean checkPhoneNumber(String input) {
        if (input.startsWith(PREFIX + TOKENS_DELIMITER)) {
            input = input.substring(2);
        }
        List<String> numbers = Arrays.asList(input.split(TOKENS_DELIMITER));
        List<Integer> lengths = numbers.stream()
                .map(String::length)
                .collect(Collectors.toList());
        boolean isDecimal = numbers.stream()
                .flatMap(str -> str.chars().mapToObj(i -> (char) i))
                .allMatch(Character::isDigit);
        return isDecimal && lengths.equals(List.of(3, 3, 4));
    }
}
```
#### **Test Java**

```java
package string.checkPhoneNumber;

import static org.junit.Assert.assertEquals;
import static string.checkPhoneNumber.CheckPhoneNumber.checkPhoneNumber;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class TestCheckPhoneNumber {
    @Test
    public void checkValidPrefixedNumber() {
        assertEquals(true, checkPhoneNumber("7-301-447-5820"));
    }

    @Test
    public void checkValidUnprefixedNumber() {
        assertEquals(true, checkPhoneNumber("301-447-5820"));
    }

    @ParameterizedTest
    @ValueSource(strings = { "301-4477-5820",
            "3X1-447-5820",
            "3014475820",
            "8-301-447-5820",
            "77-301-447-5820",
            "311-4A7-5820",
            "311-487-582B",
            "3A1-4M7-582B",
            "7-3A1-447-5820",
            "77-301-447-5820",
            "7-301-4BB-5820",
            "7-abc-abc-abc",
            "abc-abc-abc",
            "7-123-456-c-7890",
            "7-1234-567-890",
            "7-123-4567-890",

    })

    public void invalidNumbers(String number) {
        assertEquals(false, checkPhoneNumber(number));
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
