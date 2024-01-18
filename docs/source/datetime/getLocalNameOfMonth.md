### Название месяца

Напишите функцию get_month(language, number), которая принимает на вход два аргумента language – язык ru или en и number – номер месяца (от 1 до 12) и возвращает название месяца на русском или английском языке.

[Источник](https://stepik.org/lesson/334152/step/8?thread=solutions&unit=317561)

<!-- tabs: start -->
#### **Python**

```python
from datetime import datetime
import locale


def get_local_name_of_month(lang, number):
    locale.setlocale(locale.LC_ALL, lang)
    date = datetime.now().replace(month=number)
    month = date.strftime('%B').lower()
    print(month)
```
#### **Test Python**

```python
from get_local_name_of_month import *
import pytest


@pytest.mark.parametrize('lang, number, expected', [
    ('ru', 1, 'январь'),
    ('ru', 2, 'февраль'),
    ('ru', 3, 'март'),
    ('ru', 4, 'апрель'),
    ('ru', 5, 'май'),
    ('ru', 6, 'июнь'),
    ('ru', 7, 'июль'),
    ('ru', 8, 'август'),
    ('ru', 9, 'сентябрь'),
    ('ru', 10, 'октябрь'),
    ('ru', 11, 'ноябрь'),
    ('ru', 12, 'декабрь'),
    ('en', 1, 'january'),
    ('en', 2, 'february'),
    ('en', 3, 'march'),
    ('en', 4, 'april'),
    ('en', 5, 'may'),
    ('en', 6, 'june'),
    ('en', 7, 'july'),
    ('en', 8, 'august'),
    ('en', 9, 'september'),
    ('en', 10, 'october'),
    ('en', 11, 'november'),
    ('en', 12, 'december')
])
def test_get_local_name_of_month(lang, number, expected, capsys):
    get_local_name_of_month(lang, number)
    captured = capsys.readouterr().out.strip()
    assert captured == expected
```

#### **Java**

```java
package datetime.getLocalNameOfMonth;

import java.text.SimpleDateFormat;
import java.util.GregorianCalendar;
import java.util.Locale;

public class GetLocalNameOfMonth {
    public static void getLocalNameOfMonth(String lang, int number) {
        SimpleDateFormat dateFormat = new SimpleDateFormat(
                "LLLL", new Locale(lang));
        GregorianCalendar calendar = new GregorianCalendar(
                number, number - 1, number);
        System.out.println(
                dateFormat.format(calendar.getTime()).toLowerCase());
    }
}
```
#### **Test Java**

```java
package datetime.getLocalNameOfMonth;

import static org.junit.Assert.assertEquals;
import static datetime.getLocalNameOfMonth.GetLocalNameOfMonth.getLocalNameOfMonth;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class TestGetLocalNameOfMonth {
    private final ByteArrayOutputStream out = new ByteArrayOutputStream();

    @BeforeEach
    void setSystemOut() {
        System.setOut(new PrintStream(out));
    }

    @ParameterizedTest
    @CsvSource(value = {
            "'ru', 1, 'январь'",
            "'ru', 2, 'февраль'",
            "'ru', 3, 'март'",
            "'ru', 4, 'апрель'",
            "'ru', 5, 'май'",
            "'ru', 6, 'июнь'",
            "'ru', 7, 'июль'",
            "'ru', 8, 'август'",
            "'ru', 9, 'сентябрь'",
            "'ru', 10, 'октябрь'",
            "'ru', 11, 'ноябрь'",
            "'ru', 12, 'декабрь'",
            "'en', 1, 'january'",
            "'en', 2, 'february'",
            "'en', 3, 'march'",
            "'en', 4, 'april'",
            "'en', 5, 'may'",
            "'en', 6, 'june'",
            "'en', 7, 'july'",
            "'en', 8, 'august'",
            "'en', 9, 'september'",
            "'en', 10, 'october'",
            "'en', 11, 'november'",
            "'en', 12, 'december'"
    })
    void testGetLocalNameOfMonth(String lang, int number, String expected) {
        getLocalNameOfMonth(lang, number);
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

[По теме:](https://stackoverflow.com/questions/5677470/why-is-the-date-constructor-deprecated-and-what-do-i-use-instead)

[Ещё по теме:](https://divancoder.ru/2017/12/dateformatsymbols/)