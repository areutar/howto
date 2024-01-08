### Проверка простоты числа

Напишите функцию is_prime(num), которая принимает в качестве аргумента натуральное число и возвращает значение True если число является простым и False в противном случае. Число 1 не простое.

[Источник](https://stepik.org/lesson/334150/step/3?unit=317559)

<!-- tabs: start -->
#### **Python**

```python
def is_prime(num):
    num = int(num)
    dividers = [i for i in range(2, num + 1) if num % i == 0]
    result =  len(dividers) == 1
    print(result)
```

#### **Test Python**

```python
from is_prime import *
import pytest


@pytest.mark.parametrize('input, expected', [
    ('1', 'False'),
    ('10', 'False'),
    ('2', 'True'),
    ('17', 'True'),
    ('101', 'True'),
    ('100', 'False'),
    ('360000', 'False'),
    ('121', 'False')
])
def test_is_prime(input, expected, capsys):
    is_prime(input)
    captured = capsys.readouterr().out.strip()
    assert captured == expected
```

#### **Java**

```java
package numerical.isPrime;

import java.util.stream.IntStream;

public class IsPrime {
    public static boolean isPrime(int number) {
        if (number == 1) {
            return false;
        }
        return IntStream.rangeClosed(1, (int) Math.sqrt(number))
                .filter(i -> number % i == 0)
                .count() == 1;
    }
}
```

#### **Test Java**

```java
package numerical.isPrime;

import static numerical.isPrime.IsPrime.isPrime;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class TestIsPrime {
    @ParameterizedTest(name = "{arguments} is prime")
    @ValueSource(ints = { 2, 3, 5, 7, 17, 101 })
    void test_isPrime(int number) {
        assertTrue(isPrime(number));
    }

    @ParameterizedTest(name = "{arguments} is not prime")
    @ValueSource(ints = { 1, 4, 10, 100, 121, 360_000 })
    void test_isNotPrime(int number) {
        assertTrue(!isPrime(number));
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
