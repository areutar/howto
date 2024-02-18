### Метод левых прямоугольников для интегрирования

Реализуйте метод, выполняющий численное интегрирование заданной функции на заданном интервале [по формуле левых прямоугольников.](https://ru.wikipedia.org/wiki/%D0%9C%D0%B5%D1%82%D0%BE%D0%B4_%D0%BF%D1%80%D1%8F%D0%BC%D0%BE%D1%83%D0%B3%D0%BE%D0%BB%D1%8C%D0%BD%D0%B8%D0%BA%D0%BE%D0%B2)

Функция задана объектом, реализующим интерфейс java.util.function.DoubleUnaryOperator. Его метод applyAsDouble() принимает значение аргумента и возвращает значение функции в заданной точке.

Интервал интегрирования задается его конечными точками a и b, причем a<=b. Для получения достаточно точного результата используйте шаг сетки не больше $10^{−6}$.

Пример. Вызов
```java
integrate(x -> 1, 0, 10)
```
должен возвращать значение 10.

[Источник](https://stepik.org/lesson/14513/step/7?unit=4147)

<!-- tabs: start -->
#### **Python**

```python

```
#### **Test Python**

```python

```

#### **Java**

```java
package simple.leftRectangleFormula;

import java.util.function.DoubleUnaryOperator;

public class LeftRectangleFormula {
    public static double leftRectangleFormula(
            DoubleUnaryOperator f,
            double a,
            double b) {
        double step = 1e6d;
        double PRECISION = 1e-7d * (b - a);
        double firstIntegral = leftRectangleFormula(f, a, b, step);
        double precision = firstIntegral;
        while (Math.abs(precision) > PRECISION) {
            step *= 2;
            double secondIntegral = leftRectangleFormula(f, a, b, step);
            precision = Math.abs(
                    Math.abs(secondIntegral) - Math.abs(firstIntegral));
            firstIntegral = secondIntegral;
            System.out.println(firstIntegral);
        }
        return firstIntegral;
    }

    public static double leftRectangleFormula(
            DoubleUnaryOperator f,
            double a,
            double b,
            double step) {
        double sum = 0;
        double delta = Math.abs(b - a) / step;
        double leftPoint;
        for (long i = 0; i < step; i++) {
            leftPoint = a + i * delta;
            sum += f.applyAsDouble(leftPoint);
        }
        return sum * delta;
    }
}
```
#### **Test Java**

```java
package simple.leftRectangleFormula;

import static java.lang.Math.abs;
import static java.lang.Math.pow;
import static java.lang.Math.sin;
import static org.junit.Assert.assertTrue;
import static simple.leftRectangleFormula.LeftRectangleFormula.leftRectangleFormula;

import java.util.function.DoubleUnaryOperator;
import java.util.stream.Stream;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

public class TestLeftRectangleFormula {
    @ParameterizedTest
    @MethodSource("provideParams")
    void testLeftRectangleFormula(
            DoubleUnaryOperator operator,
            double start,
            double end,
            double expected,
            double delta) {
        double actual = leftRectangleFormula(operator, start, end);
        assertTrue(abs(abs(expected) - abs(actual)) <= delta);
    }

    public static Stream<Arguments> provideParams() {
        double delta = 1e-6d;
        DoubleUnaryOperator operatorOne = x -> 1;
        DoubleUnaryOperator operatorIdentity = x -> x;
        DoubleUnaryOperator operatorSin = x -> sin(x);
        DoubleUnaryOperator operatorXX = x -> pow(x, 2);
        DoubleUnaryOperator operatorXXX = x -> pow(x, 3);
        return Stream.of(
                Arguments.of(operatorOne, 0, 10, 10, delta),
                Arguments.of(operatorIdentity, -2, 2, 0, delta),
                Arguments.of(operatorSin, -2, 2, 0, delta),
                Arguments.of(operatorXX, -1, 1, 2.0 / 3, delta),
                Arguments.of(operatorXX, -1, -1, 0, delta),
                Arguments.of(operatorXXX, 2, 3, 65.0 / 4, 1e-5d),
                Arguments.of(operatorXXX, 1, 1, 0, 1e-5d)
                );
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

[Ещё по теме:]()
