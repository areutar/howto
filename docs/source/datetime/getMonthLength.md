### Получить количество дней в месяце

Напишите функцию get_days(month), которая принимает в качестве аргумента номер месяца текущего года и возвращает количество дней в этом месяце.

[Источник](https://stepik.org/lesson/331754/step/7?thread=solutions&unit=315133) 

<!-- tabs:start -->

#### **Python**
```python
from datetime import datetime
from calendar import monthrange


def get_month_length(month):
    current_year = datetime.now().year
    return monthrange(current_year, month)[1]
```
#### **Test Python**
```python
from get_month_length import *
import pytest

data = [
    (1, 31),
    (2, 29),
    (3, 31),
    (11, 30),
    (12, 31)
]


@pytest.mark.parametrize('month, expected', data)
def test_get_month_length(month, expected):
    actual = get_month_length(month)
    assert actual == expected
```

#### **Java**
```java
package datetime.getMonthLength;

import java.time.LocalDate;

public class GetMonthLength {
    public static void getMonthLength(int month) {
        LocalDate date = LocalDate.now().withMonth(month);
        int result = date.getMonth().length(date.isLeapYear());
        System.out.println(result);
    }
}
```
#### **Test Java**
```java
package datetime.getMonthLength;

import static org.junit.Assert.assertEquals;
import static datetime.getMonthLength.GetMonthLength.getMonthLength;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class TestGetMonthLength {
    private final ByteArrayOutputStream out = new ByteArrayOutputStream();

    @BeforeEach
    void setSystemOut() {
        System.setOut(new PrintStream(out));
    }

    @ParameterizedTest
    @CsvSource(value = {
            "1, 31",
            "2, 29",
            "3, 31",
            "11, 30",
            "12, 31"
    })
    void testGetMonthLength(int month, String expected) {
        getMonthLength(month);
        assertEquals(expected, out.toString().stripTrailing());
    }

    @AfterEach
    void restoreOut() {
        System.setOut(null);
    }
}
```
#### **Javascript**
```javascript

```

#### **Test Javascript**
```javascript

```

<!-- tabs:end -->
