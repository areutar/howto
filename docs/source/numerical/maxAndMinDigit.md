### Максимальная и минимальная цифра числа

Дано натуральное число n. Напишите программу, которая определяет его максимальную и минимальную цифры.

[Источник](https://stepik.org/lesson/265122/step/6?unit=246071)

<!-- tabs: start -->
#### **Python**

```python
str = input()
print('Максимальная цифра равна', max(str))
print('Минимальная цифра равна', min(str))
```

#### **Java**

```java
public static char maxDigit(String str) {
        return (char) str.chars()
                .max()
                .getAsInt();
    }
```

#### **JavaScript**

```javascript

```

<!-- tabs: end -->
