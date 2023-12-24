### Слияние упорядоченных списков

Напишите функцию merge(list1, list2), которая принимает в качестве аргументов два отсортированных по возрастанию списка, состоящих из целых чисел, и объединяет их в один отсортированный список.

[Источник](https://stepik.org/lesson/331754/step/11?unit=315133)

<!-- tabs: start -->
#### **Python**

```python
import bisect


def merge_ordered_lists1(list1, list2):   
    result = list1[:]
    for elem in list2:
        print(type(elem))
        bisect.insort_left(result, elem)
    return result


def merge_ordered_lists2(list1, list2):    
    result = []
    ind1, ind2 = 0, 0
    while ind1 < len(list1) and ind2 < len(list2):
        if list1[ind1] <= list2[ind2]:
            result.append(list1[ind1])
            ind1 += 1
        else:
            result.append(list2[ind2])
            ind2 += 1
    if ind1 == len(list1):
        result.extend(list2[ind2:])
    else:
        result.extend(list1[ind1:])
    return result
```
#### **Test Python**

```python
from merge_ordered_lists import *
import pytest

data = [
    ([1, 2, 3], [5, 6, 7, 8], [1, 2, 3, 5, 6, 7, 8]),
    ([1, 7, 10, 16], [5, 6, 13, 20], [1, 5, 6, 7, 10, 13, 16, 20]),
    ([1], [2], [1, 2]),
    ([1, 2], [1, 3], [1, 1, 2, 3]),
    ([10, 11, 12], [1, 2,  3], [1, 2, 3, 10, 11, 12]),
]


@pytest.mark.parametrize('list1, list2, expectedList', data)
def test_merge_ordered_lists1(list1, list2, expectedList):
    assert merge_ordered_lists1(list1, list2) == expectedList


@pytest.mark.parametrize('list1, list2, expectedList', data)
def test_merge_ordered_lists2(list1, list2, expectedList):
    assert merge_ordered_lists2(list1, list2) == expectedList
```

#### **Java**

```java
package sequence.mergeOrderedLists;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class MergeOrderedLists {
    public static List<Integer> mergeOrderedLists(
            List<Integer> list1, List<Integer> list2) {
        List<Integer> result = new ArrayList<>();
        Queue<Integer> queue1 = new ArrayDeque<>(list1);
        Queue<Integer> queue2 = new ArrayDeque<>(list2);
        Integer elem1 = queue1.poll();
        Integer elem2 = queue2.poll();
        while (elem1 != null || elem2 != null) {
            if (elem1 == null || (elem2 != null && elem2 <= elem1)) {
                result.add(elem2);
                elem2 = queue2.poll();
                continue;
            }
            if (elem2 == null || (elem1 != null && elem2 >= elem1)) {
                result.add(elem1);
                elem1 = queue1.poll();
            }
        }
        return result;
    }
}
```
#### **Test Java**

```java
package sequence.mergeOrderedLists;

import static org.junit.Assert.assertEquals;
import java.util.List;
import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import static sequence.mergeOrderedLists.MergeOrderedLists.*;

public class TestMergeOrderedLists {
    @ParameterizedTest
    @MethodSource("provideParams")
    void testMergeLists(List<Integer> list1,
            List<Integer> list2, List<Integer> expected) {
        List<Integer> actual = mergeOrderedLists(list1, list2);
        assertEquals(expected, actual);
    }

    private static Stream<Arguments> provideParams() {
        return Stream.of(
                Arguments.of(List.of(1, 2, 3),
                        List.of(5, 6, 7, 8),
                        List.of(1, 2, 3, 5, 6, 7, 8)),
                Arguments.of(List.of(1, 7, 10, 16),
                        List.of(5, 6, 13, 20),
                        List.of(1, 5, 6, 7, 10, 13, 16, 20)),
                Arguments.of(List.of(1),
                        List.of(2),
                        List.of(1, 2)),
                Arguments.of(List.of(1, 2),
                        List.of(1, 3),
                        List.of(1, 1, 2, 3)),
                Arguments.of(List.of(10, 11, 12),
                        List.of(1, 2, 3),
                        List.of(1, 2, 3, 10, 11, 12)),
                Arguments.of(List.of(1),
                        List.of(),
                        List.of(1)),
                Arguments.of(List.of(),
                        List.of(),
                        List.of()),
                Arguments.of(List.of(1),
                        List.of(1),
                        List.of(1, 1)));
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
