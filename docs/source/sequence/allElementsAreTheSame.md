### Одинаковые цифры

Дано натуральное число. Напишите программу, которая определяет, состоит ли указанное число из одинаковых цифр.

[Источник](https://stepik.org/lesson/265122/step/9?thread=solutions&unit=246071)

<!-- tabs: start -->
#### **Python**

```python
def all_elements_are_the_same(input):
    result = 'NO'
    if min(input) == max(input):
        result = 'YES'
    print(result)
```
#### **Test Python**

```python
from all_elements_are_the_same import *
import pytest


@pytest.mark.parametrize('input, expected', [
    ('11111', 'YES'),
    ('11112111', 'NO'),
    ('1', 'YES'),
    ('77', 'YES'),
    ('56', 'NO'),
    ('999', 'YES'),
    ('899', 'NO'),
    ('989', 'NO'),
    ('998', 'NO'),
    ('666666666666666', 'YES'),
    ('6666667666666', 'NO'),
    ('177777777777777', 'NO'),
    ('77777777777777771', 'NO'),
    ('9999999999999999999999999999', 'YES'),
    ('1211111', 'NO'),
    ('1237564', 'NO'),
    ('231', 'NO'),
    ('132', 'NO'),
    ('1000000', 'NO')
])
def test_all_elements_are_the_same(input, expected, capsys):
    all_elements_are_the_same(input)
    captured = capsys.readouterr().out.strip()
    assert captured == expected
```

#### **Java**

```java
package sequence.allElementsAreTheSame;

public class AllElementsAreTheSame {
    public static void allElementsAreTheSame(String input) {
        String result = "YES";
        if (input.length() > 1) {
            char firstChar = input.charAt(0);
            if (input.chars()
                    .anyMatch(c -> c != firstChar)) {
                result = "NO";
            }
        }
        System.out.println(result);
    }
}
```
#### **Test Java**

```java
package sequence.allElementsAreTheSame;

import static org.junit.Assert.assertEquals;
import static sequence.allElementsAreTheSame.AllElementsAreTheSame.allElementsAreTheSame;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class TestAllElementsAreTheSame {
    private final ByteArrayOutputStream out = new ByteArrayOutputStream();

    @BeforeEach
    void setSystemOut() {
        System.setOut(new PrintStream(out));
    }

    @ParameterizedTest
    @CsvSource(value = {
            "'11111', 'YES'",
            "'', 'YES'",
            "'11112111', 'NO'",
            "'1', 'YES'",
            "'77', 'YES'",
            "'56', 'NO'",
            "'999', 'YES'",
            "'899', 'NO'",
            "'989', 'NO'",
            "'998', 'NO'",
            "'666666666666666', 'YES'",
            "'6666667666666', 'NO'",
            "'177777777777777', 'NO'",
            "'77777777777777771', 'NO'",
            "'9999999999999999999999999999', 'YES'",
            "'1211111', 'NO'",
            "'1237564', 'NO'",
            "'231', 'NO'",
            "'132', 'NO'",
            "'1000000', 'NO'"
    })
    void testAllElementsAreTheSame(String input, String expected) {
        allElementsAreTheSame(input);
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
