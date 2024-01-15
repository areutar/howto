### Преобразовать в змеиный регистр

Напишите функцию convert_to_python_case(text), которая принимает в качестве аргумента строку в «верблюжьем регистре» и преобразует его в «змеиный регистр».

[Источник](https://stepik.org/lesson/334150/step/10?thread=solutions&unit=317559)

<!-- tabs: start -->
#### **Python**

```python
def convert_to_python_case(input):
    snake_list = []
    for i in range(len(input)):
        if input[i].isupper():
            if i > 0:
                snake_list.append('_')
            snake_list.append(input[i].lower())
        else:
            snake_list.append(input[i])
    result = ''.join(snake_list)
    print(result) 
```
#### **Test Python**

```python
from convert_to_python_case import *
import pytest


@pytest.mark.parametrize('input, expected', [
    ('ThisIsCamelCased', 'this_is_camel_cased'),
    ('IsPrimeNumber', 'is_prime_number'),
    ('ConvertToInt32', 'convert_to_int32'),
    ('MyMethodThatDoSomething', 'my_method_that_do_something'),
    ('IsHeFreeToGo', 'is_he_free_to_go'),
    ('FBIIsWatchingYou', 'f_b_i_is_watching_you')
])
def test_convert_to_python_case(input, expected, capsys):
    convert_to_python_case(input)
    captured = capsys.readouterr().out.strip()
    assert captured == expected
```

#### **Java**

```java
package string.convertToPythonCase;

import java.util.stream.Collectors;

public class ConvertToPythonCase {
    public static void convertToPythonCase(String input) {
        String result = input.chars()
                .mapToObj(i -> (char) i)
                .map(ch -> Character.isUpperCase(ch)
                        ? "_" + String.valueOf(ch).toLowerCase()
                        : String.valueOf(ch))
                .collect(Collectors.joining());

        if (result.startsWith("_")) {
            result = result.substring(1);
        }
        System.out.println(result);
    }
}
```
#### **Test Java**

```java
package string.convertToPythonCase;

import static org.junit.Assert.assertEquals;
import static string.convertToPythonCase.ConvertToPythonCase.convertToPythonCase;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class TestConvertToPythonCase {
    private final ByteArrayOutputStream out = new ByteArrayOutputStream();

    @BeforeEach
    void setSystemOut() {
        System.setOut(new PrintStream(out));
    }

    @ParameterizedTest
    @CsvSource(value = {
            "'ThisIsCamelCased', 'this_is_camel_cased'",
            "'IsPrimeNumber', 'is_prime_number'",
            "'ConvertToInt32', 'convert_to_int32'",
            "'MyMethodThatDoSomething', 'my_method_that_do_something'",
            "'IsHeFreeToGo', 'is_he_free_to_go'",
            "'FBIIsWatchingYou', 'f_b_i_is_watching_you'"
    })
    void testConvertToPythonCase(String input, String expected) {
        convertToPythonCase(input);
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
