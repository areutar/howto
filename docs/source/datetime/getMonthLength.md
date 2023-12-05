### Получить количество дней в месяце

### Описание:
Напишите функцию get_days(month), которая принимает в качестве аргумента номер месяца и возвращает количество дней в данном месяце.  

1. Гарантируется, что передаваемый аргумент находится в диапазоне от 1 до 12.
2. Считайте, что год является невисокосным.

#### [Источник](https://stepik.org/lesson/331754/step/7?thread=solutions&unit=315133) 

<!-- tabs:start -->

#### **Python**
```python
from datetime import datetime
from calendar import monthrange

def get_days(month):
    current_year = datetime.now().year
    return monthrange(current_year, month)[1]
```
#### **Test Python**
```python
import pytest
import arithm
data = [
    (1, 31),
    (2, 28),
    (3, 31),
    (11, 30),
    (12, 31)
]

@pytest.mark.parametrize('input, expected', data)
def test_arithm(input, expected):
    assert arithm.get_days(input) == expected
```

#### **Java**
```java
public static int getMonthLength(int month) {
        LocalDate date = LocalDate.now().withMonth(month);
        return date.getMonth().length(date.isLeapYear());
    }
```
#### **Test Java**
```java
package tests;
import static org.junit.Assert.assertEquals;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import home.F;

public class FTest {
    @ParameterizedTest
    @CsvSource(
        value  = 
        {"1, 31", "2, 28", "8, 31", "11, 30", "12, 31"}
    )
    void testGetMonthLength(int month, int length) {
        assertEquals(F.getMonthLength(month), length);
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
