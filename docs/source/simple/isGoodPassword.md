### Валидация качества пароля

Напишите функцию is_password_good(password), которая принимает в качестве аргумента строковое значение пароля **password** и возвращает значение True, если пароль является надежным и False - в противном случае.

Пароль является надежным если:

* его длина не менее 8 символов; 
* он содержит как минимум одну заглавную букву (верхний регистр); 
* он содержит как минимум одну строчную букву (нижний регистр);
* он содержит хотя бы одну цифру.

[Источник](https://stepik.org/lesson/334150/step/5?unit=317559)

<!-- tabs: start -->
#### **Python**

```python
def has_digit(password):
   return len([ch for ch in password if ch.isdigit()]) > 0

def has_upper(password):
   return len([ch for ch in password if ch.isupper()]) > 0

def has_lower(password):
   return len([ch for ch in password if ch.islower()]) > 0

def has_big_length(password):
   return len(password) >= 8

def is_good_password(password):
    return has_digit(password) and has_upper(password) and \
    has_lower(password) and has_big_length(password)
```

#### **Test Python**

```python
from __future__ import absolute_import
from python.p import is_good_password
import pytest

@pytest.mark.parametrize('password, answer', [
    ('aaAA12qqp', True),
    ('AAPPqq9S', True),
    ('99yyPPgg', True),
    ('aaaaaaaaaaaaa', False),
    ('AAAAAAAAAAA', False),
    ('734638763978653', False),
    ('AABBccssss',  False),
    ('AA23423423',  False),
    ('dsas233232232', False),
    ('99yyPPg', False),
    ('()+_№;%:', False),
    ('aaaaaaA@', False),
])
def test_good_password(password, answer):
    assert is_good_password(password) == answer
```

#### **Java**

```java
package main.java;
public class J {
    public static void main(String[] args) {
    }
    public static boolean isGoodPassword(String pas) {
        boolean hasDigit = pas.chars()
                .mapToObj(i -> (char) i)
                .anyMatch(c -> Character.isDigit(c));
        boolean hasLower = pas.chars()
                .mapToObj(i -> (char) i)
                .anyMatch(c -> Character.isLowerCase(c));
        boolean hasUpper = pas.chars()
                .mapToObj(i -> (char) i)
                .anyMatch(c -> Character.isUpperCase(c));
        return pas.length() >= 8 && hasDigit && hasLower && hasUpper;
    }
}
```

#### **Test Java**

```java
package tests;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.params.ParameterizedTest.ARGUMENTS_PLACEHOLDER;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import main.java.J;
public class JTest {
    @ParameterizedTest(name = ARGUMENTS_PLACEHOLDER + " is good password")
    @ValueSource(strings = { "aaAA12qqp", "AAPPqq9S", "99yyPPgg" })
    void testIsGoodPassword(String password) {
        assertTrue(J.isGoodPassword(password));
    }
    @ParameterizedTest(name = ARGUMENTS_PLACEHOLDER + " is not good password")
    @ValueSource(strings = { "aaaaaaaaaaaaa", "AAAAAAAAAAAAA", "734638763978653",
            "AABBccssss", "AA23423423", "dsas233232232",
            "99yyPPg", "()+_№;%:", "aaaaaaA@" })
    void testIsNotGoodPassword(String password) {
        assertFalse(J.isGoodPassword(password));
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
