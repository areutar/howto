### Числа Рамануджана

Сриниваса Рамануджан – индийский математик, славившийся своей интуицией в области чисел. Когда английский математик Годфри Харди навестил его однажды в больнице, он обмолвился, что номером такси, на котором он приехал, было 1729, такое скучное и заурядное число. На что Рамануджан ответил: "Нет, нет! Это очень интересное число. Это наименьшее число, выражаемое как сумма двух кубов двумя разными способами". Другими словами: 1729 = 1\*1\*1+12\*12\*12 = 9\*9\*9+10\*10\*10.

Напишите программу, которая находит аналогичные интересные числа. В ответе запишите первые 5 чисел в порядке возрастания, включая число 1729.

#### первое число, раскладываемое в сумму кубов тремя способами - 87539319
[87539319, 167, 436, 228, 423, 255, 414]

[Источник](https://stepik.org/lesson/294080/step/7?unit=275759)

<!-- tabs: start -->
#### **Python**

```python
def get_ramanujan_numbers(threshold):
    sums = {}
    result = {}

    for i in range(threshold):
        for j in range(i + 1, threshold):
            current = i ** 3 + j ** 3
            if current in sums:
                sums[current] = sums[current] + [i, j]
            else:
                sums[current] = [i, j]

    for sum, args in sums.items():
        if len(args) > 2:
            result[sum] = args

    sorted_result = sorted(result.items())
    return sorted_result
```

#### **Test Python**

```python
from ramanujan_numbers import get_ramanujan_numbers
from time import time

threshold = 1000
output = ''
start = time()
numbers = get_ramanujan_numbers(threshold)
end = time()
exec_time = int((end - start) * 1000)
output += f'Для чисел меньших {threshold} найдено '\
    f'{len(numbers)} чисел Рамануджана\n'
output += f'Время выполнения - {exec_time}ms\n\n'
with open('./src/numerical/RamanujanNumbers/python_test.txt',
          'w',
          encoding='utf-8') as test_file:
    test_file.write(output)
    for number in numbers:
        test_file.write(str(number) + '\n')
```
Для чисел меньших 1000 найдено 1582 чисел Рамануджана

Время выполнения - 959ms

#### **Java**

```java
package numerical.RamanujanNumbers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RamanujanNumbers {
    public static List<List<Long>> getRamanujanNumbers2(int threshold) {
        Map<Long, List<Long>> mapSumPairs = new HashMap<>();
        List<List<Long>> result = new ArrayList<>();
        long[] cubes = new long[threshold];
        for (long i = 0; i < threshold; i++) {
            cubes[(int) (i)] = i * i * i;
        }

        for (int i = 0; i < threshold; i++) {
            for (int j = 0; j < threshold; j++) {
                if (i < j) {
                    Long sum = cubes[i] + cubes[j];
                    List<Long> currents = new ArrayList<Long>(
                            Arrays.asList((long) i, (long) j));

                    mapSumPairs.merge(sum, currents, (t, u) -> {
                        t.addAll(u);
                        return t;
                    });
                }
            }
        }

        for (Map.Entry<Long, List<Long>> pair : mapSumPairs.entrySet()) {
            if (pair.getValue().size() > 2) {
                List<Long> current = new ArrayList<>(pair.getValue());
                current.add(0, pair.getKey());
                result.add(current);
            }
        }

        result.sort((o1, o2) -> (int) (o1.get(0) - o2.get(0)));
        return result;
    }
}
```
#### **Test Java**

```java
package numerical.RamanujanNumbers;

import static numerical.RamanujanNumbers.RamanujanNumbers.getRamanujanNumbers2;

import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.List;

public class TestRamanujanNumbers {
    public static void main(String[] args) throws IOException {
        int threshold = 1000;
        StringBuilder builder = new StringBuilder();

        long start = System.currentTimeMillis();
        List<List<Long>> sums = getRamanujanNumbers2(threshold);
        long end = System.currentTimeMillis();
        builder.append(String.format(
                "Для чисел меньших %d найдено %d чисел Рамануджана%n",
                threshold, sums.size()));
        builder.append(String.format(
                "Время выполнения - %dms%n%n",
                end - start));

        FileWriter writer = new FileWriter(
                "./src/numerical/RamanujanNumbers/java_test.txt",
                StandardCharsets.UTF_8);
        writer.write(builder.toString());
        for (List<Long> list : sums) {
            writer.write(list.toString() + System.lineSeparator());
        }
        writer.close();
    }
}
```
Для чисел меньших 1000 найдено 1582 чисел Рамануджана

Время выполнения - 565ms

#### **JavaScript**

```javascript

```
#### **Test JavaScript**

```javascript

```
<!-- tabs: end -->

[Решения от гиков](https://www.geeksforgeeks.org/find-all-ramanujan-numbers-that-can-be-formed-by-numbers-upto-l/)

[Кватерн Рамануджана](https://ru.wikiital.com/wiki/Quaterne_di_Ramanujan)