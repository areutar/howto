### Гипотеза Эйлера о сумме степеней

В 1769 году Леонард Эйлер сформулировал обобщенную версию Великой теоремы Ферма, предполагая, что по крайней мере n энных степеней необходимо для получения суммы, которая сама является энной степенью для n>2. Напишите программу для опровержения гипотезы Эйлера (продержавшейся до 1967 года) и найдите четыре положительных целых числа, сумма 5-х степеней которых равна 5-й степени другого положительного целого числа.

Таким образом, найдите пять натуральных чисел a, b, c, d, e удовлетворяющих условию:
a5+b5+c5+d5=e5. (27 84 110 133 144)

[Источник](https://stepik.org/lesson/298795/step/13?discussion=4107623&unit=280622)

<!-- tabs: start -->
#### **Python**

```python
def four_fifths_problem(threshold):
    degrees5 = [i ** 5 for i in range(threshold)]
    result = []
    for i in range(1, threshold):
        for j in range(i, threshold):
            for k in range(j, threshold):
                for l in range(k, threshold):
                    root = (degrees5[i] + degrees5[j] + degrees5[k]
                            + degrees5[l]) ** (1/5)                    
                    if (root - int(root)) < 0.0000000000001:
                        result.append([i, j, k, l, int(root)])
    return result
```
#### **Test Python**

```python
from four_fifths_problem import *
from time import time

start = time()
result = four_fifths_problem(150)
end = time()
elapsed = int((end - start) * 1000)
print(f'Время выполнения {elapsed}ms')
print(result)
```
'Время выполнения 16183ms'

[[27, 84, 110, 133, 144]]
#### **Java**

```java
package numerical.fourFifthsProblem;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.LongStream;
import static java.lang.Math.*;

public class FourFifthsProblem {
    public static List<List<Long>> fourFifthsProblem(int threshold) {
        List<Long> degrees5 = LongStream.range(0, threshold)
                .map(i -> i * i * i * i * i)
                .boxed()
                .collect(Collectors.toList());
        List<List<Long>> result = new ArrayList<>();

        for (int i = 1; i < threshold; i++) {
            for (int j = i; j < threshold; j++) {
                for (int k = j; k < threshold; k++) {
                    for (int l = k; l < threshold; l++) {
                        double root = pow(
                                degrees5.get(i) + degrees5.get(j)
                                        + degrees5.get(k) + degrees5.get(l),
                                0.2);

                        if ((root - (long) root) < 0.0000000000001) {
                            result.add(Arrays.asList(
                                    (long) i, (long) j, (long) k,
                                    (long) l, (long) root));
                        }
                    }
                }
            }
        }
        return result;
    }
}
```
#### **Test Java**

```java
package numerical.fourFifthsProblem;

import static numerical.fourFifthsProblem.FourFifthsProblem.fourFifthsProblem;

public class TestFourFifthsProblem {
    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        System.out.println(fourFifthsProblem(150));
        long end = System.currentTimeMillis();
        System.out.printf("Время выполнения - %dms", end - start);
    }   
}
```
[[27, 84, 110, 133, 144]]

Время выполнения - 901ms

#### **JavaScript**

```javascript

```
#### **Test JavaScript**

```javascript

```
<!-- tabs: end -->

[Ещё по теме:](https://ru.wikipedia.org/wiki/%D0%93%D0%B8%D0%BF%D0%BE%D1%82%D0%B5%D0%B7%D0%B0_%D0%AD%D0%B9%D0%BB%D0%B5%D1%80%D0%B0)
