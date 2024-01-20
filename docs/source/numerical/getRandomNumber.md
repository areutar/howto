### Получить случайное число

Как получить случайное целое(вещественное) число в некотором интервале?

[Источник](https://docs.python.org/3/library/random.html)

[Источник](https://stackoverflow.com/questions/363681/how-do-i-generate-random-integers-within-a-specific-range-in-java)

<!-- tabs: start -->
#### **Python**

```python
// случайное целое в интервале от min до max (max не входит)
i = randrange(min, max, step)

// случайное целое в интервале от min до max (max входит)
i = randint(min, max)

// случайное вещественное в интервале от min до max
d = uniform(min, max)
```

#### **Java**

```java
// случайное целое в интервале от min до max (max входит)
int min = -10;
int max = -5;
int rand = min + new Random().nextInt(max - min + 1);
int randint = min + (int) Math.random() * (max - min + 1);
int randomNum = ThreadLocalRandom.current().nextInt(min, max + 1);

// случайное вещественное в интервале от min до max
double randd = min + new Random().nextDouble() * (max - min);
double randintd = min + Math.random() * (max - min);
double randomNumd = ThreadLocalRandom.current().nextDouble(min, max);

```

#### **JavaScript**

```javascript

```
<!-- tabs: end -->
