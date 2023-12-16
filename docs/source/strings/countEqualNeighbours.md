### Одинаковые соседи

На вход программе подается одна строка. Напишите программу, которая определяет сколько в ней одинаковых соседних символов.

[Источник](https://stepik.org/lesson/284101/step/13?thread=solutions&unit=265440)

<!-- tabs: start -->
#### **Python**

```python
def count_equal_neighbours(input):
    return len([i for i in range(len(input) - 1)
            if input[i] == input[i + 1]])
```
#### **Test Python**

```python
from count_equal_neighbours import *
import pytest


@pytest.mark.parametrize('input, expected', [
    ('abcd', 0),
    ('aabbcc', 3),
    ('aaa', 2),
    ('aaaabbccd', 5),
    ('aaabbaaa', 5)
])
def test_count_equal_neighbours(input, expected):
    assert count_equal_neighbours(input) == expected

```

#### **Java**

```java
package string.countEqualNeighbours;

import java.util.stream.IntStream;

public class CountEqualNeighbours {
    public static int countEqualNeighbours(String str) {
        return (int) IntStream.range(0, str.length() - 1)
                .filter(i -> str.charAt(i) == str.charAt(i + 1))
                .count();
    }

}
```
#### **Test Java**

```java
package string.countEqualNeighbours;

import static org.junit.Assert.assertEquals;
import static string.countEqualNeighbours.CountEqualNeighbours.countEqualNeighbours;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class TestCountEqualNeighbours {

    @ParameterizedTest
    @CsvSource(value = {
            "abcd, 0",
            "aabbcc, 3",
            "333, 2",
            "aaaabbccd, 5",
            "aaabbaaa, 5",
    })
    void testCountEqualNeighbours(String input, int expected) {
        assertEquals(expected, countEqualNeighbours(input));
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
