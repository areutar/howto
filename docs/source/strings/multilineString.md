### Многострочная строка

Иногда у нас есть очень длинная строка, и мы хотим записать ее в несколько строк для лучшей читаемости кода. 

На **python** это можно сделать с помощью:
* тройных кавычек
* скобок
* обратного слэша
* join

[Источник](https://www.geeksforgeeks.org/multiline-string-in-python/)

На **java** это можно сделать с помощью:
* тройных кавычек (java 15)
* конкатенации
* String.join
* …

[Источник](https://www.baeldung.com/java-multiline-string)



<!-- tabs: start -->
#### **Python**

```python
text = 'line1\nline2\nline3'

text_with_single_triple_quotes = '''line1
line2
line3'''

text_with_double_triple_quotes = """line1
line2
line3"""

text_with_parentheses = ("line1\n"
                         "line2\n"
                         "line3")

text_with_backslash = "line1\n\
line2\n\
line3"

text_with_join = "".join((
    "line1\n",
    "line2\n",
    "line3"
))

text_with_square_brackets = [
    'line1\n'
    'line2\n'
    'line3'
]

```
#### **Test Python**

```python
from multilineString import *

def test__text_with_single_triple_quotes():
    assert text == text_with_single_triple_quotes

def test__text_with_double_triple_quotes():
    assert text == text_with_double_triple_quotes

def test__text_with_parentheses():
    assert text == text_with_parentheses

def test__text_with_backslash():
    assert text == text_with_backslash

def test__text_with_join():
    assert text == text_with_join

def test__text_with_square_brackets():
    assert text == text_with_square_brackets[0]

```

#### **Java**

```java
package string.multylineString;
public class MultilineString {
    static String text = "line1\nline2\nline3";

    static String textWithConcatenation = "line1\n"
            .concat("line2\n")
            .concat("line3");

    static String textWithStringJoin = String.join("\n",
            "line1",
            "line2",
            "line3");
}
```
#### **Test Java**

```java
package string.multylineString;
import static org.junit.Assert.assertEquals;
import static string.multylineString.MultylineString.*;
import org.junit.Test;
public class TestMultilineString {
    @Test
    public void testConcatenateStrings() {
        assertEquals(text, textWithConcatenation);
    }
    @Test
    public void testJoinStrings() {
        assertEquals(text, textWithStringJoin);
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
