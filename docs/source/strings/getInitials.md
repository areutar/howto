### Инициалы

На вход программе подается строка текста, содержащая имя, отчество и фамилию человека. Напишите программу, которая выводит инициалы человека. После каждого инициала ставится точка.

[Источник](https://stepik.org/lesson/324755/step/4?unit=307931)

<!-- tabs: start -->
#### **Python**

```python
def get_initials(str):
  first_letters = [word[0] for word in str.split()]
  return '.'.join(first_letters) + '.'
```
#### **Test Python**

```python
from get_initials import get_initials
import pytest


@pytest.mark.parametrize('input, expected',
                         [('Владимир Семенович Высоцкий', 'В.С.В.'),
                          ('Гуев Тимур Ахсарбекович', 'Г.Т.А.'),
                          ('Михаил Иванович Кузнецов', 'М.И.К.')])
def test_get_initials(input, expected):
    assert get_initials(input) == expected

```

#### **Java**

```java
package string.getInitials;

import java.util.Arrays;
import java.util.stream.Collectors;

public class GetInitials {

    public static String getInitials(String input) {
    return Arrays.stream(input.split("\\s"))
    .map(s -> s.charAt(0) + ".")
    .collect(Collectors.joining());
  }
}
```
#### **Test Java**

```java
package string.getInitials;

import static org.junit.Assert.assertEquals;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class TestGetInitials {
    @ParameterizedTest
    @CsvSource(delimiter = '|', value = { "Владимир Семенович Высоцкий|В.С.В.",
            "Гуев Тимур Ахсарбекович|Г.Т.А.",
            "Михаил Иванович Кузнецов|М.И.К." })
    void testGetInitials(String input, String expected) {
        assertEquals(expected, GetInitials.getInitials(input));
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
