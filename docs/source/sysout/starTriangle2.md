### Звёздный треугольник

Дано нечетное натуральное число n. Напишите программу, которая печатает равнобедренный звездный треугольник с основанием, равным n в соответствии с примером:

\*  
\**  
\***  
\****  
\***  
\**  
\*  

[Источник](https://stepik.org/lesson/298795/step/8?thread=solutions&unit=280622)

<!-- tabs: start -->
#### **Python**

```python
def star_triangle2(input):
    height = int(input) // 2 + 1
    for i in range(-height + 1, height):
        print('*' * (height - abs(i)))
```
#### **Test Python**

```python
from star_triangle2 import *
import pytest


@pytest.mark.parametrize('input, expected', [
    ('3',
     '''*
**
*'''
     ),
    ('5',
     """*
**
***
**
*"""
     ),
     ('11',
      '''*
**
***
****
*****
******
*****
****
***
**
*'''
      )
])
def test_star_triangle2(input, expected, capsys):
    star_triangle2(input)
    captured = capsys.readouterr().out.strip()
    assert captured == expected

```

#### **Java**

```java
package sysout.starTriangle2;

public class StarTriangle2 {

    public static void starTriangle2(int number) {
        if (number % 2 == 0 || number <= 0) {
            throw new IllegalArgumentException();
        }
        int height = number / 2 + 1;
        for (int i = -height + 1; i < height; i++) {
            System.out.println("*".repeat(height - Math.abs(i)));
        }
    }

}
```

#### **Test Java**

```java
package sysout.starTriangle2;

import static org.junit.Assert.assertEquals;
import static sysout.starTriangle2.StarTriangle2.starTriangle2;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.stream.Stream;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

public class TestStarTriangle2 {
    private final ByteArrayOutputStream out = new ByteArrayOutputStream();
    private static final String sep = System.lineSeparator();

    @BeforeEach
    void setSystemOut() {
        System.setOut(new PrintStream(out));
    }

    @ParameterizedTest
    @MethodSource("provideParams")
    void testStarTriangle2(int input, String expected) {
        starTriangle2(input);
        assertEquals(expected, out.toString().stripTrailing());
    }

    public static Stream<Arguments> provideParams() {
        return Stream.of(
                Arguments.of("3",
                        "*" + sep
                                + "**" + sep
                                + "*"),
                Arguments.of("5",
                        "*" + sep
                                + "**" + sep
                                + "***" + sep
                                + "**" + sep
                                + "*"),
                Arguments.of("11",
                        "*" + sep
                                + "**" + sep
                                + "***" + sep
                                + "****" + sep
                                + "*****" + sep
                                + "******" + sep
                                + "*****" + sep
                                + "****" + sep
                                + "***" + sep
                                + "**" + sep
                                + "*"));
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
