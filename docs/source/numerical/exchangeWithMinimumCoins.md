### Ведьмаку заплатите чеканной монетой

Всем известно, что ведьмак способен одолеть любых чудовищ, однако его услуги обойдутся недешево. К тому же ведьмак не принимает купюры, он принимает только чеканные монеты. В мире ведьмака существуют монеты с номиналами 1, 5, 10, 25. Напишите программу, которая определяет, какое минимальное количество чеканных монет нужно заплатить ведьмаку.

[Источник](https://stepik.org/lesson/265121/step/14?unit=246070)

<!-- tabs: start -->
#### **Python**

```python
def exchange_with_minimum_coins(coins, cash):
    count = 0
    for i in range(len(coins) - 1, - 1, -1):
        count += cash // coins[i]
        cash %= coins[i]
    print(count)
```
#### **Test Python**

```python
from exchange_with_minimum_coins import *
import pytest

coins = [1, 5, 10, 25]


@pytest.mark.parametrize('input, expected', [
    (49, 7),
    (1, 1),
    (5, 1),
    (10, 1),
    (25, 1),
    (2111, 86),
    (4, 4),
    (100, 4),
    (499, 25),
    (9, 5)
])
def test_exchange_with_minimum_coins(input, expected, capsys):
    exchange_with_minimum_coins(coins, input)
    captured = int(capsys.readouterr().out.strip())
    assert captured == expected

```

#### **Java**

```java
package numerical.exchangeWithMinimumCoins;

import java.util.List;

public class ExchangeWithMinimumCoins {
    public static void exchangeWithMinimumCoins(
            List<Integer> coins, int cash) {
        int count = 0;
        for (int i = coins.size() - 1; i >= 0; i--) {
            count += cash / coins.get(i);
            cash = cash % coins.get(i);
        }
        System.out.println(count);
    }
}
```
#### **Test Java**

```java
package numerical.exchangeWithMinimumCoins;

import static numerical.exchangeWithMinimumCoins.ExchangeWithMinimumCoins.exchangeWithMinimumCoins;
import static org.junit.Assert.assertEquals;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.List;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class TestExchangeWithMinimumCoins {
    private final ByteArrayOutputStream out = new ByteArrayOutputStream();
    private final List<Integer> coins = List.of(1, 5, 10, 25);

    @BeforeEach
    void setSystemOut() {
        System.setOut(new PrintStream(out));
    }

    @ParameterizedTest
    @CsvSource(value = {
            "49, 7",
            "1, 1",
            "5, 1",
            "10, 1",
            "25, 1",
            "2111, 86",
            "4, 4",
            "100, 4",
            "499, 25",
            "9, 5"
    })
    void testExchangeWithMinimumCoins(int cash, String expected) {
        exchangeWithMinimumCoins(coins, cash);
        assertEquals(expected, out.toString().stripTrailing());
    }

    @AfterEach
    void restoreOut() {
        System.setOut(null);
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
