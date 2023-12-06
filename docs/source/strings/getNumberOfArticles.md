### Подсчёт артиклей:

На вход программе подается строка, содержащая английский текст. Напишите программу, которая подсчитывает общее количество артиклей: 'a', 'an', 'the'.

[Источник](https://stepik.org/lesson/324754/step/7?thread=solutions&unit=307930)

<!-- tabs: start -->
#### **Python**

```python
def get_number_of_articles(string):
    text_list = string.lower().split()
    articles = ['a', 'an', 'the']
    count = 0
    for article in articles:
        count += text_list.count(article)
    print(f'Общее количество артиклей: {count}')
```
#### **Test Python**

```python

```

#### **Java**

```java
public static int getNumberOfArticles(String input) {
        List<String> articles = List.of("an", "a", "the");
        List<String> words = Arrays.stream(input.split("\\s"))
                .map(String::toLowerCase)
                .collect(Collectors.toList());
        return articles.stream()
                .mapToInt(article -> Collections.frequency(words, article))
                .sum();
    }
```
#### **Test Java**

```java

```

#### **JavaScript**

```javascript

```
#### **Test JavaScript**

```javascript

```
<!-- tabs: end -->
