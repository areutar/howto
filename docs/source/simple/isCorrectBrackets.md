### Правильная скобочная последовательность

Напишите функцию is_correct_bracket(text), которая принимает в качестве аргумента непустую строку text, состоящую из символов '(' и ')' и возвращает значение True, если поступившая на вход строка является правильной скобочной последовательностью и False в противном случае.

Правильной скобочной последовательностью называется строка, состоящая только из символов '(' и ')', где каждой открывающей скобке найдется парная закрывающая скобка (при этом каждая открывающая скобка должна быть левее соответствующей ей закрывающей скобки).

[Источник](https://stepik.org/lesson/334150/step/9?unit=317559)

<!-- tabs: start -->
#### **Python**

```python
def is_correct_brackets(input):
    count = 0
    for ch in input:
        if ch == '(':
            count += 1
        if ch == ')':
            count -= 1
        if count < 0:
            break
    print(count == 0)
```
#### **Test Python**

```python
from is_correct_brackets import *
import pytest


@pytest.mark.parametrize('input, expected', [
    ('((()))', 'True'),
    ('(()())', 'True'),
    ('(())()', 'True'),
    ('()(())', 'True'),
    ('()()()', 'True'),
    ('()(())()()()(())()(()())((()))', 'True'),
    ('()(())()(()())((()))()(())', 'True'),
    ('())()()()(', 'False'),
    (')))(((', 'False'),
    ('()(())()((())((()))()(())', 'False'),
    ('()(())()(()())((()))()(()', 'False'),
    (')(())()(()())((()))()(())', 'False'),
    ('())(()', 'False'),
    (')))', 'False'),
    ('((((', 'False'),
    ('())((((())))', 'False')
])
def test_is_correct_brackets(input, expected, capsys):
    is_correct_brackets(input)
    captured = capsys.readouterr().out.strip()
    assert captured == expected
```

#### **Java**

```java
package simple.isCorrectBrackets;

public class IsCorrectBrackets {
    public static void isCorrectBrackets(String input) {
        int count = 0;
        for (Character ch : input.toCharArray()) {
            if (ch == '(') {
                count++;
            }
            if (ch == ')') {
                count--;
            }
            if (count < 0) {
                break;
            }
        }
        System.out.println(count == 0);
    }
}
```
#### **Test Java**

```java
package simple.isCorrectBrackets;

import static org.junit.Assert.assertEquals;
import static simple.isCorrectBrackets.IsCorrectBrackets.isCorrectBrackets;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class TestIsCorrectBrackets {
    private final ByteArrayOutputStream out = new ByteArrayOutputStream();

    @BeforeEach
    void setSystemOut() {
        System.setOut(new PrintStream(out));
    }

    @ParameterizedTest
    @CsvSource(value = {
            "'((()))', 'true'",
            "'(()())', 'true'",
            "'(())()', 'true'",
            "'()(())', 'true'",
            "'()()()', 'true'",
            "'()(())()()()(())()(()())((()))', 'true'",
            "'()(())()(()())((()))()(())', 'true'",
            "'())()()()(', 'false'",
            "')))(((', 'false'",
            "'()(())()((())((()))()(())', 'false'",
            "'()(())()(()())((()))()(()', 'false'",
            "')(())()(()())((()))()(())', 'false'",
            "'())(()', 'false'",
            "')))', 'false'",
            "'((((', 'false'",
            "'())((((())))', 'false'"
    })
    void testIsCorrectBrackets(String input, String expected) {
        isCorrectBrackets(input);
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
