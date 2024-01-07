### Разбиение строки по символу новой строки

Разбить строку на подстроки, используя символ новой строки, учитывая, что в разных операционных системах символ новой строки разный.

В Windows используется другой разделитель строки, чем в системах Unix/Linux или Mac. Mac использует отдельный символ возврата каретки (представленный как \r) для обозначения конца строки. Unix, с другой стороны, использует символ новой строки (перевода строки) \n. Windows использует оба варианта: символ возврата каретки, за которым следует символ перевода строки (\r\n) в качестве признака конца строки.

[Источник](https://www.baeldung.com/java-string-split-by-newline)
[Источник](https://www.geeksforgeeks.org/python-ways-to-split-strings-using-newline-delimiter/)

<!-- tabs: start -->
#### **Python**

```python
import re

str = 'Geeks\nFor\nGeeks\n'

# Method #1: Using splitlines() 
print(str.splitlines())

# Method #2: Using split() method
print(str.rstrip().split('\n'))

# Method #3: Use the re module 
print(re.split('\n', str))

# Method #4: Using the re.findall() method with a regular expression
print(re.findall(r'[^\n]+', str))
```

#### **Java**

```java
// Split String by Newline Using the System#lineSeparator Method
String[] lines = "Line1\r\nLine2\r\nLine3".split(System.lineSeparator());

// Split String by Newline Using Regular Expressions
String[] lines = "Line1\nLine2\nLine3".split("\\r?\\n|\\r");
String[] lines = "Line1\rLine2\rLine3".split("\\r?\\n|\\r");
String[] lines = "Line1\r\nLine2\r\nLine3".split("\\r?\\n|\\r");
String[] lines = str.split("[\r\n]+");

// Split String by Newline in Java 8
String[] lines = "Line1\nLine2\nLine3".split("\\R");
String[] lines = "Line1\rLine2\rLine3".split("\\R");
String[] lines = "Line1\r\nLine2\r\nLine3".split("\\R");

// Split String by Newline Using Pattern Class
Pattern pattern = Pattern.compile("\\R");
Stream<String> lines = pattern.splitAsStream("Line1\nLine2\nLine3");
Stream<String> lines = pattern.splitAsStream("Line1\rLine2\rLine3");
Stream<String> lines = pattern.splitAsStream("Line1\r\nLine2\r\nLine3");

// Split String by Newline in Java 11
Stream<String> lines = "Line1\nLine2\rLine3\r\nLine4".lines();
```

#### **JavaScript**

```javascript

```

<!-- tabs: end -->
