### Сортировка символов строки

Из символов избраной строки получить строку с теми же символами, но упорядоченными по возрастанию.

[Источник]()

<!-- tabs: start -->
#### **Python**

```python
def sort_string(input):
    chars = list(input)
    chars.sort(key=ord)
    return "".join(chars)
```
#### **Test Python**

```python
from sort_string import *
import pytest


@pytest.mark.parametrize('input, expected', [
    ('', ''),
    ('a', 'a'),
    ('ab', 'ab'),
    ('a!a', '!aa'),
    ('a b', ' ab'),
    ('ba b', ' abb'),
    ('ёе', 'её')
])
def test_sort_string(input, expected):
    assert sort_string(input) == expected
```

#### **Java**

```java
package string.sortString;

import java.util.stream.Collectors;

public class SortString {
    public static String sortString(String input) {
        return input.chars()
                .sorted()
                .mapToObj(i -> (char) i)
                .map(String::valueOf)
                .collect(Collectors.joining());
    }
}
```
#### **Test Java**

```java
package string.sortString;

import static org.junit.Assert.assertEquals;
import static string.sortString.SortString.sortString;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class TestSortString {

    @ParameterizedTest
    // @MethodSource("provideParams")
    @CsvSource(value = {
            "' ', ' '",
            "'a', 'a'",
            "'ab', 'ab'",
            "'a!a', '!aa'",
            "'a b', ' ab'",
            "'ba b', ' abb'",
            "'ёе', 'её'"
    })
    void testSortString(String input, String expected) {
        assertEquals(expected, sortString(input));
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
