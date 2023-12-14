### Самый частотный символ

На вход программе подается строка текста. Напишите программу, которая выводит на экран символ, который появляется наиболее часто. (если таких символов несколько, следует вывести последний по порядку символ)

[Источник](https://stepik.org/lesson/303083/step/13?unit=284990)

<!-- tabs: start -->
#### **Python**

```python
def most_frequent_symbol(input):
    max_frequency = 0
    sign_frequent = ''
    symbols = []
    for c in input:
        if c in symbols:
            continue
        symbols.append(c)
        current_frequency = input.count(c)
        if current_frequency >= max_frequency:
            max_frequency = current_frequency
            sign_frequent = c
    return sign_frequent
```
#### **Test Python**

```python
from most_frequent_symbol import *
import pytest

data = [
    ('aaaabbc', 'a'),
    ('abaabbcccc', 'c'),
    ('pppppppppppppppppppppuuuuuuuuuuuuuuuuuuuuuuqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqq', 'q'),
    ('asasasasasppppppppppppppppppppppppppqw', 'p'),
    ('aaaAAAA', 'A'),
    ('привет питонннннннннннннннНННН', 'н'),
    ('11111111111111111111111111111111111111', '1'),
    ("""jfnmdbsdfnsjfqenfdssjdfhsdjlkppppppppppppppppppggggg
 xxzzzssswwwwwwwwwwwwwwwwwwfgdfxdfg""", 'w')
]


@pytest.mark.parametrize('input, expected', data)
def test_most_frequent_symbol(input, expected):
    assert expected == most_frequent_symbol(input)

```

#### **Java**

```java
package string.mostFrequentSymbol;

import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class MostFrequentSymbol {
    public static char getMostFrequentSymbol(String str) {
        List<Character> strList = str.chars()
                .mapToObj(i -> (char) i)
                .collect(Collectors.toList());
        Map<Character, Integer> map = strList.stream()
                .collect(Collectors.toMap(
                        Function.identity(), c -> 1, (c1, c2) -> c1 + c2));
        return map.keySet().stream()
                .max((c1, c2) -> {
                    int fr = map.get(c1) - map.get(c2);
                    int in = str.lastIndexOf(c1) - str.lastIndexOf(c2);
                    return fr == 0 ? in : fr;
                }).get();
    }

}
```
#### **Test Java**

```java
package string.mostFrequentSymbol;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class TestMostFrequentSymbol {
    @ParameterizedTest
    @CsvSource(value = {
            "aaaabbc, a",
            "abaabbcccc, c",
            "pppppppppppppppppppppuuuuuuuuuuuuuuuuuuuuuuqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqq, q",
            "asasasasasppppppppppppppppppppppppppqw, p",
            "aaaAAAA, A",
            "привет питонннннннннннннннНННН, н",
            "11111111111111111111111111111111111111, 1",
            "jfnmdbsdfnsjfqenfdssjdfhsdjlkpppppppppppppppp"
                    + "ppgggggxxzzzssswwwwwwwwwwwwwwwwwwfgdfxdfg, w",
    })
    void testGetMostFrequentSymbol() {

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
