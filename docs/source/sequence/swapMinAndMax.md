### Поменять min и max местами

На вход программе подается строка текста, содержащая натуральные числа. Из данной строки формируется список чисел. Напишите программу, которая меняет местами минимальный и максимальный элемент этого списка.

[Источник](https://stepik.org/lesson/324754/step/6?unit=307930)

<!-- tabs: start -->
#### **Python**

```python
def swap_min_and_max(string):
    numbers = string.split()
    mn = min(numbers, key=int)
    mx = max(numbers, key=int)
    for i in range(len(numbers)):
        if numbers[i] == mn:
          numbers[i] = mx
        elif numbers[i] == mx:
          numbers[i] = mn
    print(*numbers)
```
#### **Test Python**

```python
from swap_min_and_max import *
import pytest


@pytest.mark.parametrize('input, expected', [
    ('3 4 5 2 1', '3 4 1 2 5'),
    ('10 9 8 7 6 5 4 3 2 1', '1 9 8 7 6 5 4 3 2 10'),
    ('1 2', '2 1'),
    ('1', '1'),
    ('1 1 1 1 1', '1 1 1 1 1'),
    ('2 1', '1 2'),
    ('2 1 1', '1 2 2'),
    ('1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16 17 180 19 20 21 22',
        '180 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16 17 1 19 20 21 22'),
    ('1 2 3 4 5 6 7 8 9 10', '10 2 3 4 5 6 7 8 9 1'),
    ('1 5 4 3 2', '5 1 4 3 2'),
])
def test_swap_min_and_max(input, expected, capsys):
    swap_min_and_max(input)
    captured = capsys.readouterr().out.strip()
    assert captured == expected
```

#### **Java**

```java
package sequence.swapMinAndMax;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class SwapMinAndMax {
    public static void swapMinAndMax(String input) {
        List<Integer> numbers = Arrays.stream(input.split("\\s+"))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
        Integer mx = Collections.max(numbers);
        Integer mn = Collections.min(numbers);
        List<String> swapedNumbers = numbers.stream()
                .map(n -> {
                    if (n == mx) {
                        n = mn;
                    } else if (n == mn) {
                        n = mx;
                    }
                    return String.valueOf(n);
                })
                .collect(Collectors.toList());
        System.out.println(String.join(" ", swapedNumbers));
    }

}
```
#### **Test Java**

```java
package sequence.swapMinAndMax;

import static org.junit.Assert.assertEquals;
import static sequence.swapMinAndMax.SwapMinAndMax.swapMinAndMax;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class TestSwapMinAndMax {
    private final ByteArrayOutputStream out = new ByteArrayOutputStream();

    @BeforeEach
    void setSystemOut() {
        System.setOut(new PrintStream(out));
    }

    @ParameterizedTest
    @CsvSource(value = {
            "3 4 5 2 1, 3 4 1 2 5",
            "10 9 8 7 6 5 4 3 2 1, 1 9 8 7 6 5 4 3 2 10",
            "1 2, 2 1",
            "1, 1",
            "1 1 1 1 1, 1 1 1 1 1",
            "2 1, 1 2",
            "2 1 1, 1 2 2",
            "1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16 17 180 19 20 21 22, 180 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16 17 1 19 20 21 22",
            "1 2 3 4 5 6 7 8 9 10, 10 2 3 4 5 6 7 8 9 1",
            "1 5 4 3 2, 5 1 4 3 2"
    })
    void testSwapMinAndMax(String input, String expected) {
        swapMinAndMax(input);
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
