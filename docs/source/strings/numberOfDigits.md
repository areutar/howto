### Количество цифр
На вход программе подается строка текста. Напишите программу, которая подсчитывает количество цифр в данной строке.

[Источник](https://stepik.org/lesson/303083/step/11?unit=284990)

<!-- tabs: start -->
#### **Python**

```python
def count_digits(str):
    return len([c for c in str if c.isdigit()])
```
#### **Test Python**

```python

```

#### **Java**

```java
public static int countDigits(String str) {
        return (int) str.chars()
                .filter(Character::isDigit)
                .count();
    }
```
#### **Test Java**

```java

```

#### **JavaScript**

```javascript

```
#### **Test JavaScript**

```javascript

```
<!-- tabs: end -->
