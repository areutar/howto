### Изменить один бит

Реализуйте метод flipBit, изменяющий значение одного бита заданного целого числа на противоположное. Данная задача актуальна, например, при работе с битовыми полями.

Договоримся, что биты нумеруются от младшего (индекс 1) к старшему (индекс 32).

[Источник](https://stepik.org/lesson/12759/step/15?unit=3107)

<!-- tabs: start -->
#### **Python**

```python
def flip_bit(value, bit_index):
    return value ^ (1 << bit_index - 1)
```
#### **Test Python**

```python
from flip_bit import *
import pytest

data = [
    (1, 1, 0),
    (0, 1, 1),
    (0b11, 1, 0b10),
    (0b10, 1, 0b11),
    (0b10, 2, 0),
    (0b11111111, 4, 0b11110111)
]


@pytest.mark.parametrize('value, bit_index, expected', data)
def test_flip_bit(value, bit_index, expected):
    actual = flip_bit(value, bit_index)
    assert actual == expected
```

#### **Java**

```java
package numerical.flipBit;

public class FlipBit {
    /**
     * Flips one bit of the given <code>value</code>.
     *
     * @param value    any number
     * @param bitIndex index of the bit to flip, 1 <= bitIndex <= 32
     * @return new value with one bit flipped
     */
    public static int flipBit(int value, int bitIndex) {
        int bitMask = 1 << (bitIndex - 1);
        return value ^ bitMask;
    }
}
```
#### **Test Java**

```java
package numerical.flipBit;

import static numerical.flipBit.FlipBit.flipBit;
import static org.junit.Assert.assertEquals;

import java.util.stream.Stream;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

public class TestFlipBit {

    @ParameterizedTest
    @MethodSource("provideParams")

    void testFlipBit(int value, int bitIndex, int expected) {
        int actual = flipBit(value, bitIndex);
        assertEquals(expected, actual);
    }

    public static Stream<Arguments> provideParams() {
        return Stream.of(
                Arguments.of(0, 1, 1),
                Arguments.of(1, 1, 0),
                Arguments.of(0b11, 1, 0b10),
                Arguments.of(0b10, 1, 0b11),
                Arguments.of(0b10, 2, 0),
                Arguments.of(0b11111111, 4, 0b11110111));
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

[Ещё по теме:](https://javarush.com/quests/lectures/questmultithreading.level10.lecture10)
