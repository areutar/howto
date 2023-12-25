### Определить арифметическую прогрессию

На входе список целых чисел, нужно определить являются ли они куском арифметической прогрессии.

[Источник](https://stepik.org/lesson/265081/step/9?unit=246029)

<!-- tabs: start -->
#### **Python**

```python
def detect_progression(numbers):
    numbers = sorted(numbers)
    differences = [numbers[i + 1] - numbers[i]
                   for i in range(len(numbers) - 1)]
    print(differences.count(differences[0]) == len(differences))
```
#### **Test Python**

```python
from detect_progression import *
import pytest


@pytest.mark.parametrize('input, expected', [
    ([1, 2], 'True'),
    ([2, 1], 'True'),
    ([1, 2, 3], 'True'),
    ([0, -3, 3, -6], 'True'),
    ([18, 15, 6, 9, 12, 3, 0], 'True'),
    ([1, 2, 4], 'False'),
    ([1, 2, 3, 2], 'False'),
    ([1, 2, 3, 5], 'False'),
    ([2, 4, 8], 'False'),
    ([10, 5, 0], 'True'),
    ([1, 1, 1, 1, 1, 1], 'True'),
    ([1000, 2000, 3000], 'True'),
    ([25, 125, 224], 'False'),
])
def test_detect_progression(input, expected, capsys):
    detect_progression(input)
    captured = capsys.readouterr().out.rstrip()
    assert captured == expected
```

#### **Java**

```java
package sequence.detectProgression;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.IntStream;

public class DetectProgression {
    public static void detectProgression(List<Integer> numbers) {
        List<Integer> copyList = new ArrayList<>(numbers);
        Collections.sort(copyList);
        boolean result = IntStream.range(0, copyList.size() - 1)
                .map(i -> copyList.get(i + 1) - copyList.get(i))
                .distinct()
                .count() == 1L;
        System.out.println(result);
    }
}
```
#### **Test Java**

```java
package sequence.detectProgression;

import static org.junit.Assert.assertEquals;
import static sequence.detectProgression.DetectProgression.detectProgression;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.List;
import java.util.stream.Stream;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

public class TestDetectProgression {
    private final ByteArrayOutputStream out = new ByteArrayOutputStream();

    @BeforeEach
    void setSystemOut() {
        System.setOut(new PrintStream(out));
    }

    @ParameterizedTest
    @MethodSource("provideParams")
    void testDetectProgression(List<Integer> input, String expected) {
        detectProgression(input);
        assertEquals(expected, out.toString().stripTrailing());
    }

    private static Stream<Arguments> provideParams() {
        return Stream.of(
                Arguments.of(List.of(1, 2), "true"),
                Arguments.of(List.of(2, 1), "true"),
                Arguments.of(List.of(2, 1, 3), "true"),
                Arguments.of(List.of(0, -3, 3, -6), "true"),
                Arguments.of(List.of(18, 15, 6, 9, 12, 3, 0), "true"),
                Arguments.of(List.of(1, 2, 4), "false"),
                Arguments.of(List.of(1, 2, 3, 2), "false"),
                Arguments.of(List.of(1, 2, 3, 5), "false"),
                Arguments.of(List.of(2, 4, 8), "false"),
                Arguments.of(List.of(10, 5, 0), "true"),
                Arguments.of(List.of(1, 1, 1, 1, 1, 1, 1), "true"),
                Arguments.of(List.of(1000, 2000, 3000), "true"),
                Arguments.of(List.of(25, 125, 224), "false"));
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
