### Проверка сторон треугольника

Напишите функцию is_valid_triangle(side1, side2, side3), которая принимает в качестве аргументов три натуральных числа, и возвращает значение True если существует невырожденный треугольник со сторонами side1, side2, side3 и False в противном случае.

[Источник](https://stepik.org/lesson/334150/step/2?thread=solutions&unit=317559)

<!-- tabs: start -->
#### **Python**

```python
def is_valid_triangle(sides):
    result = sum(sides) > 2 * max(sides)
    print(result)
```
#### **Test Python**

```python
from is_valid_triangle import *
import pytest


@pytest.mark.parametrize('sides, expected', [
    ([2, 2, 2], 'True'),
    ([2, 3, 10], 'False'),
    ([3, 4, 5], 'True'),
    ([10, 11, 12], 'True'),
    ([12, 10, 2], 'False'),
    ([100, 1, 2], 'False')
])
def test_is_valid_triangle(sides, expected, capsys):
    is_valid_triangle(sides)
    captured = capsys.readouterr().out.strip()
    assert captured == expected
```

#### **Java**

```java
package numerical.isValidTriangle;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class IsValidTriangle {
    public static void isValidTriangle(String input) {
        List<Integer> sides = Arrays.stream(input.split("\\s+"))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
        int max = sides.stream().max(Comparator.naturalOrder()).get();
        int sum = sides.stream()
                .mapToInt(Integer::intValue)
                .sum();
        System.out.println(sum > 2 * max);
    }
}
```
#### **Test Java**

```java
package numerical.isValidTriangle;

import static org.junit.Assert.assertEquals;
import static numerical.isValidTriangle.IsValidTriangle.isValidTriangle;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class TestIsValidTriangle {
    private final ByteArrayOutputStream out = new ByteArrayOutputStream();

    @BeforeEach
    void setSystemOut() {
        System.setOut(new PrintStream(out));
    }

    @ParameterizedTest
    @CsvSource(value = {
            "'2 2 2', 'true'",
            "'2 3 10', false",
            "'3 4 5', true",
            "'10 11 12', true",
            "'12 10 2', false",
            "'100 1 2', false"
    })
    void testIsValidTriangle(String input, String expected) {
        isValidTriangle(input);
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
