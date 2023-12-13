### Каждый третий

На вход программе подается строка текста. Напишите программу, которая удаляет из нее все символы с индексами кратными 3, то есть символы с индексами 0, 3, 6, ....

[Источник](https://stepik.org/lesson/313233/step/7?unit=295750)

<!-- tabs: start -->
#### **Python**

```python
def every_third_with_del(input):
  lst = input[:]
  del lst[::3]
  return ''.join(lst)

def every_third(input):
  return ''.join([input[i] for i in range(len(input)) if i % 3 != 0])


```
#### **Test Python**

```python
from every_third import *
import pytest

data = [
('Python', 'yton'),
('Hello', 'elo'),
('qwer', 'we'),
('p', ''),
('ab', 'b'),
('abc', 'bc'),
('abcdefg', 'bcef'),
('abcdefghij', 'bcefhi'),
('abcdefghijkl', 'bcefhikl'),
('qwertyuiopasdfghjklzxcvbnm', 'wetyioasfgjkzxvbm'),
]


@pytest.mark.parametrize("input, expected", data)
def test_every_third(input, expected):
    assert expected == every_third(input)

@pytest.mark.parametrize("input, expected", data)
def test_every_third_with_del(input, expected):
    assert expected == every_third_with_del(input)

```

#### **Java**

```java
package string.everyThird;

import java.util.stream.IntStream;

public class EveryThird {
    public static String everyThird(String str) {
        return IntStream.range(0, str.length())
                .filter(i -> i % 3 != 0)
                .mapToObj(str::charAt)
                .collect(StringBuilder::new, StringBuilder::append,
                        StringBuilder::append)
                .toString();
    }
}

```
#### **Test Java**

```java
package string.everyThird;

import static org.junit.Assert.assertEquals;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class TestEveryThird {
    @ParameterizedTest
    @CsvSource(value = {
            "Python, yton",
            "Hello, elo",
            "qwer, we",
            "p, ''",
            "ab, b",
            "abc, bc",
            "abcdefg, bcef",
            "abcdefghij, bcefhi",
            "abcdefghijkl, bcefhikl",
            "qwertyuiopasdfghjklzxcvbnm, wetyioasfgjkzxvbm",
            "карандаш, арндш",
    })
    void testEveryThird(String input, String expected) {
        assertEquals(expected, EveryThird.everyThird(input));
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
