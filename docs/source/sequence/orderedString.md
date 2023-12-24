### Упорядоченность строки

Напишите программу, проверяющую, явлются ли символы строки упорядоченными по убыванию.

[Источник](https://stepik.org/lesson/265122/step/10?discussion=1564992&unit=246071)

<!-- tabs: start -->
#### **Python**

```python
def ordered_string(input):
    return input == ''.join(sorted(input, reverse=True))
```
#### **Test Python**

```python
from ordered_string import *
import pytest


@pytest.mark.parametrize('input, expected', [
    ('5321', True),
    ('7820', False),
    ('9663', True),
    ('9876543210', True),
    ('987654329', False),
    ('12345', False),
    ('54332222221111', True),
    ('987654341', False),
    ('98768974321', False),
    ('987654328', False),
    ('111111111', True),
    ('6543211', True),
    ('6593211', False)
])
def test_ordered_string(input, expected):
    assert ordered_string(input) == expected
```

#### **Java**

```java
package sequence.orderedString;

import java.util.Comparator;
import java.util.stream.Collectors;

public class OrderedString {
    public static boolean orderedString(String input) {
        if (input.length() <= 1) {
            return true;
        }
        return input.equals(sortString(input));
    }

    public static String sortString(String input) {
        return input.chars()
                .mapToObj(i -> (char) i)
                .sorted(Comparator.reverseOrder())
                .map(String::valueOf)
                .collect(Collectors.joining());
    }
}
```
#### **Test Java**

```java
package sequence.orderedString;

import static org.junit.Assert.assertEquals;
import static sequence.orderedString.OrderedString.orderedString;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class TestOrderedString {

    @ParameterizedTest
    @CsvSource(value = {
            "5321, true",
            "7820, false",
            "9663, true",
            "9876543210, true",
            "987654329, false",
            "12345, false",
            "54332222221111, true",
            "987654341, false",
            "98768974321, false",
            "987654328, false",
            "111111111, true",
            "6543211, true",
            "6593211, false",
    })
    void testOrderedString(String input, boolean expected) {
        assertEquals(expected, orderedString(input));
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
