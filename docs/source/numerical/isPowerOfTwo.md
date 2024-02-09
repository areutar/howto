### Степень двойки

Реализуйте метод, проверяющий, является ли заданное число по абсолютной величине степенью двойки.

Решать можно разными способами:
* воспользовавшись одним удобным статическим методом из класса java.lang.Integer;
* применив пару трюков из двоичной арифметики;
* написав решение "в лоб" с циклом и условными операторами (можете вернуться к этой задаче после просмотра соответствующих уроков).

[Источник](https://stepik.org/lesson/12760/step/9?thread=solutions&unit=3108)

<!-- tabs: start -->
#### **Python**

```python
def is_power_of_two(value):
    result = bin(value).count('1') == 1
    print(result)
```
#### **Test Python**

```python
from is_power_of_two import *
import pytest


@pytest.mark.parametrize('value, expected', [
    (0, 'False'),
    (1, 'True'),
    (2, 'True'),
    (-2, 'True'),
    (63, 'False'),
    (-256, 'True'),
    (1073741824, 'True'),
    (-2147483648, 'True')
])
def test_is_power_of_two(value, expected, capsys):
    is_power_of_two(value)
    captured = capsys.readouterr().out.strip()
    assert captured == expected
```

#### **Java**

```java
package numerical.isPowerOfTwo;

public class IsPowerOfTwo {
    public static void isPowerOfTwo1(int value) {
        if (value < 0) {
            value = -value;
        }
        boolean result = value != 0 &&
                Integer.highestOneBit(value) == value;
        System.out.println(result);
    }

    public static void isPowerOfTwo2(int value) {
        if (value < 0) {
            value = -value;
        }
        boolean result = Integer.toBinaryString(value).chars()
                .map(c -> Character.digit(c, 2))
                .sum() == 1;
        System.out.println(result);
    }

    public static void isPowerOfTwo3(int value) {
        if (value < 0) {
            value = -value;
        }
        boolean result = value != 0 && (value & (value - 1)) == 0;
        System.out.println(result);
    }

    public static void isPowerOfTwo4(int value) {
        if (value < 0) {
            value = -value;
        }
        boolean result = value != 0 && (value & -value) == value;
        System.out.println(result);
    }
}
```
#### **Test Java**

```java
package numerical.isPowerOfTwo;

import static org.junit.Assert.assertEquals;
import static numerical.isPowerOfTwo.IsPowerOfTwo.*;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class TestIsPowerOfTwo {
    private final ByteArrayOutputStream out = new ByteArrayOutputStream();
    private final String s0 = "0, 'false'";
    private final String s1 = "1, 'true'";
    private final String s2 = "2, 'true'";
    private final String s_2 = "-2, 'true'";
    private final String s63 = "63, 'false'";
    private final String s_256 = "-256, 'true'";
    private final String sMaxHalf = "1073741824, 'true'";
    private final String sMin = "-2147483648, 'true'";

    @BeforeEach
    void setSystemOut() {
        System.setOut(new PrintStream(out));
    }

    @ParameterizedTest
    @CsvSource(value = {
            s0, s1, s2, s_2, s63, s_256, sMaxHalf, sMin
    })
    void testIsPowerOfTwo(int value, String expected) {
        isPowerOfTwo1(value);
        assertEquals(expected, out.toString().stripTrailing());
    }

    @ParameterizedTest
    @CsvSource(value = {
            s0, s1, s2, s_2, s63, s_256, sMaxHalf, sMin
    })
    void testIsPowerOfTwo2(int value, String expected) {
        isPowerOfTwo2(value);
        assertEquals(expected, out.toString().stripTrailing());
    }

    @ParameterizedTest
    @CsvSource(value = {
            s0, s1, s2, s_2, s63, s_256, sMaxHalf, sMin
    })
    void testIsPowerOfTwo3(int value, String expected) {
        isPowerOfTwo3(value);
        assertEquals(expected, out.toString().stripTrailing());
    }

    @ParameterizedTest
    @CsvSource(value = {
            s0, s1, s2, s_2, s63, s_256, sMaxHalf, sMin
    })
    void testIsPowerOfTwo4(int value, String expected) {
        isPowerOfTwo4(value);
        assertEquals(expected, out.toString().stripTrailing());
    }

    @AfterEach
    void restoreOut() {
        System.setOut(null);
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

[Ещё по теме:]()
