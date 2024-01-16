### Звёздный треугольник 1

Дано натуральное число n. Напишите программу, которая печатает равнобедренный звёздный треугольник с высотой n в соответствии с примером:

        *  
       ***  
      *****  
     *******  
    *********  

[Источник](https://stepik.org/lesson/334152/step/4?unit=317561)

<!-- tabs: start -->
#### **Python**

```python
def star_triangle1(number):
    for i in range(number):
        print((number - 1 - i)*' ' + (2 * i + 1) * '*')
```
#### **Test Python**

```python
from star_triangle1 import *
import pytest


@pytest.mark.parametrize('input, expected', [
    (1, """*
"""),
    (2, """ *
***
"""),
    (8, ('       *\n'
     '      ***\n'
         '     *****\n'
         '    *******\n'
         '   *********\n'
         '  ***********\n'
         ' *************\n'
         '***************\n')
     )
])
def test_star_triangle1(input, expected, capsys):
    star_triangle1(input)
    captured = capsys.readouterr().out
    assert captured == expected
```

#### **Java**

```java
package sysout.starTriangle1;

public class StarTriangle1 {
    public static void starTriangle1(int number) {
        for (int i = 0; i < number; i++) {
            System.out.print(" ".repeat(number - i - 1));
            System.out.println("*".repeat(2 * i + 1));
        }
    }
}
```
#### **Test Java**

```java
package sysout.starTriangle1;

import static org.junit.Assert.assertEquals;
import static sysout.starTriangle1.StarTriangle1.starTriangle1;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.stream.Stream;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

public class TestStarTriangle1 {
    private final ByteArrayOutputStream out = new ByteArrayOutputStream();
    private static final String sep = System.lineSeparator();

    @BeforeEach
    void setSystemOut() {
        System.setOut(new PrintStream(out));
    }

    @ParameterizedTest
    @MethodSource("provideParams")
    void testStarTriangle1(int number, String expected) {
        starTriangle1(number);
        assertEquals(expected, out.toString());
    }

    public static Stream<Arguments> provideParams() {
        return Stream.of(
                Arguments.of(
                        1, "*" + sep),
                Arguments.of(
                        2,
                        " *" + sep
                                + "***" + sep),
                Arguments.of(
                        8,
                        "       *" + sep
                                + "      ***" + sep
                                + "     *****" + sep
                                + "    *******" + sep
                                + "   *********" + sep
                                + "  ***********" + sep
                                + " *************" + sep
                                + "***************" + sep));
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
