### Числа Рамануджана

Сриниваса Рамануджан – индийский математик, славившийся своей интуицией в области чисел. Когда английский математик Годфри Харди навестил его однажды в больнице, он обмолвился, что номером такси, на котором он приехал, было 1729, такое скучное и заурядное число. На что Рамануджан ответил: "Нет, нет! Это очень интересное число. Это наименьшее число, выражаемое как сумма двух кубов двумя разными способами". Другими словами: 1729 = 1\*1\*1+12\*12\*12 = 9\*9\*9+10\*10\*10.

Напишите программу, которая находит аналогичные интересные числа. В ответе запишите первые 5 чисел в порядке возрастания, включая число 1729.

[Источник](https://stepik.org/lesson/294080/step/7?unit=275759)

<!-- tabs: start -->
#### **Python**

```python
def getSumOfCubes(threshold):
    amounts = []
    for i in range(threshold):
        for j in range(threshold):
            if i >= j:
                continue
            else:
                amounts.append((i, j, i ** 3 + j ** 3))
    return amounts


def get_ramanujan_numbers(threshold):
    amounts = getSumOfCubes(threshold)
    ramanujan_numbers = []
    for i, j, sum1 in amounts:
        for k, l, sum2 in amounts:
            if sum1 == sum2 and i != k:
                ramanujan_numbers.append((i, j, sum1))
    ramanujan_numbers.sort(key=lambda x: x[2])
    return ramanujan_numbers
```
#### **Test Python**
Для чисел меньших 50 найдено 24 чисел Рамануджана<br>
Время выполнения - 90ms

Для чисел меньших 100 найдено 90 чисел Рамануджана<br>
Время выполнения - 1322ms

Для чисел меньших 150 найдено 156 чисел Рамануджана<br>
Время выполнения - 6113ms

```python
from ramanujan_numbers import get_ramanujan_numbers
from time import time

thresholds = [50, 100, 150]
output = ''
for threshold in thresholds:
    start = time()
    numbers = get_ramanujan_numbers(threshold)
    end = time()
    exec_time = int((end - start) * 1000)
    output += f'Для чисел меньших {threshold} найдено '\
        f'{len(numbers)} чисел Рамануджана\n'
    output += f'Время выполнения - {exec_time}ms\n\n'
print(output)

```

#### **Java**

```java
package numerical.RamanujanNumbers;

import java.util.ArrayList;
import java.util.List;

public class RamanujanNumbers {
    public static List<List<Integer>> getSumOfCubes(int threshold) {
        List<List<Integer>> sums = new ArrayList<>();
        for (int i = 0; i < threshold; i++) {
            for (int j = 0; j < threshold; j++) {
                if (i >= j) {
                    continue;
                } else {
                    sums.add(List.of(i, j, i * i * i + j * j * j));
                }
            }
        }
        return sums;

    }

    public static List<List<Integer>> getRamanujanNumbers(int threshold) {
        List<List<Integer>> sums = getSumOfCubes(threshold);
        List<List<Integer>> result = new ArrayList<>();
        for (List<Integer> sum1 : sums) {
            for (List<Integer> sum2 : sums) {
                if (sum1.get(2).equals(sum2.get(2))
                        && !sum1.get(0).equals(sum2.get(0))) {
                    result.add(sum1);
                }
            }
        }
        result.sort((o1, o2) -> o1.get(2) - o2.get(2));
        return result;
    }

}
```
#### **Test Java**
Для чисел меньших 50 найдено 24 чисел Рамануджана<br>
Время выполнения - 59ms

Для чисел меньших 100 найдено 90 чисел Рамануджана<br>
Время выполнения - 237ms

Для чисел меньших 150 найдено 156 чисел Рамануджана<br>
Время выполнения - 738ms

Для чисел меньших 200 найдено 270 чисел Рамануджана<br>
Время выполнения - 3681ms

```java
package numerical.RamanujanNumbers;

import static numerical.RamanujanNumbers.RamanujanNumbers.getRamanujanNumbers;

import java.util.Arrays;
import java.util.List;

public class TestRamanujanNumbers {
    public static void main(String[] args) {
        List<Integer> thresholds = Arrays.asList(50, 100, 150, 200);
        StringBuilder builder = new StringBuilder();
        for (Integer threshold : thresholds) {
            long start = System.currentTimeMillis();
            List<List<Integer>> sums = getRamanujanNumbers(threshold);
            long end = System.currentTimeMillis();
            builder.append(String.format(
                    "Для чисел меньших %d найдено %d чисел Рамануджана%n",
                    threshold, sums.size()));
            builder.append(String.format(
                    "Время выполнения - %dms%n%n",
                    end - start));
        }
        System.out.println(builder.toString());
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

[Ещё по теме:](https://www.geeksforgeeks.org/find-all-ramanujan-numbers-that-can-be-formed-by-numbers-upto-l/)
