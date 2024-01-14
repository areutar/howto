### Правильная скобочная последовательность 2

Определить правильность скобочной последовательности, в которой могут быть скобки трёх видов: ([{}])

Правильной скобочной последовательностью называется строка, состоящая только из скобок, в которой все скобки можно разбить на пары таким образом, что:
* в каждой паре есть левая и правая скобка, причем левая скобка расположена левее правой;
* для любых двух пар скобок либо одна из них полностью находится внутри другой пары, либо промежутки между скобками в парах не пересекаются;
* в паре с круглой скобкой может быть только круглая скобка, с квадратной — квадратная, с фигурной — фигурная.

[Определение взято отсюда](https://апо.рф/%D0%BC%D0%B0%D1%82%D0%B5%D1%80%D0%B8%D0%B0%D0%BB%D1%8B/%d0%bf%d1%80%d0%b0%d0%b2%d0%b8%d0%bb%d1%8c%d0%bd%d1%8b%d0%b5-%d1%81%d0%ba%d0%be%d0%b1%d0%be%d1%87%d0%bd%d1%8b%d0%b5-%d0%bf%d0%be%d1%81%d0%bb%d0%b5%d0%b4%d0%be%d0%b2%d0%b0%d1%82%d0%b5%d0%bb%d1%8c%d0%bd/)

[мысли по поводу](/source/sequence/isCorrectBrackets2Thoughts.md)

<!-- tabs: start -->
#### **Python**

```python
def is_correct_brackets2(input):
    ROUND_BRACKETS = '()'
    SQUARE_BRACKETS = '[]'
    CURLY_BRACKETS = '{}'
    brackets_pairs = [ROUND_BRACKETS, SQUARE_BRACKETS, CURLY_BRACKETS]
    BRACKETS = '([{}])'
    only_brackets = ''.join([ch for ch in input if ch in BRACKETS])
    while ROUND_BRACKETS in only_brackets \
        or SQUARE_BRACKETS in only_brackets \
            or CURLY_BRACKETS in only_brackets:
        for bracket_pair in brackets_pairs:
            if bracket_pair in only_brackets:
                only_brackets = only_brackets.replace(bracket_pair, "")
    result = not only_brackets
    print(result)
```
#### **Test Python**

```python
from is_correct_brackets2 import *
import pytest


@pytest.mark.parametrize('input, expected', [
    ('()', 'True'),
    ('[]', 'True'),
    ('{}', 'True'),

    ('([][]  ){}', 'True'),
    ('([][]  ){lst = [1, 2]}', 'True'),
    ('([()()()..])', 'True'),
    ('''def test_is_correct_brackets2(input, expected, capsys):
    is_correct_brackets2(input)
    captured = capsys.readouterr().out.strip()
    assert captured == expected''', 'True'),
    ('''Runnable r = new Runnable() {             
            public void run() 
            { 
                System.out.println("run"); 
            } 
        }; ''', 'True'),
    ('([{([{([{}])}])}])', 'True'),
    ('(){[]}[({})[([{}])]]{([{{}}])}', 'True'),

    ('(', 'False'),
    ('[', 'False'),
    ('{', 'False'),
    (')', 'False'),
    (']', 'False'),
    ('}', 'False'),

    (')(', 'False'),
    ('][', 'False'),
    ('}{', 'False'),

    ('(]', 'False'),
    ('(}', 'False'),
    ('[)', 'False'),
    ('[}', 'False'),
    ('{)', 'False'),
    ('{]', 'False'),

    ('([)]', 'False'),
    ('({)}', 'False'),
    ('[(])', 'False'),
    ('[{]}', 'False'),
    ('{(})', 'False'),
    ('{[}]', 'False'),
], ids=[
    'simple_sequence_round_brackets',
    'simple_sequence_square_brackets',
    'simple_sequence_curly_brackets',

    'function_with_two_list_args',
    'function_with_list_initialization',
    'this_parametrize_test',
    'this_testing_function',
    'anonymous_class',
    'many_brackets',
    'ascending_brackets',

    'wrong_count_round_opening',
    'wrong_count_square_opening',
    'wrong_count_curly_opening',
    'wrong_count_round_closing',
    'wrong_count_square_closing',
    'wrong_count_curly_closing',

    'wrong_order_two_round',
    'wrong_order_two_square',
    'wrong_order_two_curly',

    'different_brackets_round+square',
    'different_brackets_round+curly',
    'different_brackets_square+round',
    'different_brackets_square+curly',
    'different_brackets_curly+round',
    'different_brackets_curly+square',

    'wrong_order_round+square',
    'wrong_order_round+curly',
    'wrong_order_square+round',
    'wrong_order_square+curly',
    'wrong_order_curly+round',
    'wrong_order_curly+square',
])
def test_is_correct_brackets2(input, expected, capsys):
    is_correct_brackets2(input)
    captured = capsys.readouterr().out.strip()
    assert captured == expected
```

#### **Java**

```java
package sequence.isCorrectBrackets2;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Map;

public class IsCorrectBrackets2 {
    public static final Map<Character, Character> brackets = Map.of(
            '(', ')',
            '[', ']',
            '{', '}');

    public static void isCorrectBrackets2(String input) {
        Deque<Character> stack = new ArrayDeque<>();
        boolean result = true;
        for (int i = 0; i < input.length(); i++) {
            Character current = input.charAt(i);
            if (brackets.containsKey(current)) {
                stack.push(current);
            }
            if (brackets.containsValue(current) && (stack.isEmpty() ||
                    brackets.get(stack.pop()) != current)) {
                result = false;
                break;
            }
        }
        if (result) {
            result = stack.isEmpty();
        }
        System.out.println(result);
    }
}
```
#### **Test Java**

```java
package sequence.isCorrectBrackets2;

import static org.junit.Assert.assertEquals;
import static sequence.isCorrectBrackets2.IsCorrectBrackets2.isCorrectBrackets2;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class TestIsCorrectBrackets2 {
    private final ByteArrayOutputStream out = new ByteArrayOutputStream();

    @BeforeEach
    void setSystemOut() {
        System.setOut(new PrintStream(out));
    }

    @ParameterizedTest(name = "{index}: {0} - {1}")
    @CsvSource(value = {
            "'()', 'true'",
            "'[]', 'true'",
            "'{}', 'true'",

            "'([][]  ){}', 'true'",
            "'([][]  ){lst = [1, 2]}', 'true'",
            "'([()()()..])', 'true'",
            "'([{([{([{}])}])}])', 'true'",
            "'(){[]}[({})[([{}])]]{([{{}}])}', 'true'",

            "'(', 'false'",
            "'[', 'false'",
            "'{', 'false'",
            "')', 'false'",
            "']', 'false'",
            "'}', 'false'",

            "')(', 'false'",
            "'][', 'false'",
            "'}{', 'false'",

            "'(]', 'false'",
            "'(}', 'false'",
            "'[)', 'false'",
            "'[}', 'false'",
            "'{)', 'false'",
            "'{]', 'false'",

            "'([)]', 'false'",
            "'({)}', 'false'",
            "'[(])', 'false'",
            "'[{]}', 'false'",
            "'{(})', 'false'",
            "'{[}]', 'false'",
    })
    void testIsCorrectBrackets2(String input, String expected) {
        isCorrectBrackets2(input);
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
