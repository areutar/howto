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
from number_of_articles import get_number_of_articles

import pytest

data = [
    ('A An The', 3),

    ('''a a a a a A and An an ana ana aba ab ab 
     The the a a theh the opathe''', 13),

    ("""William Shakespeare was born in the town 
of Stratford, England, in the year 1564. When 
he was a young man, Shakespeare moved to the 
city of London, where he began writing plays. 
His plays were soon very successful, and were 
enjoyed both by the common people of London 
and also by the rich and famous. In addition 
to his plays, Shakespeare wrote many short poems 
and a few longer poems. Like his plays, these 
poems are still famous today.""", 7),

    ("""There have been many great writers in the
history of English literature, but there is
no doubt about which writer was the greatest.
Many people consider William Shakespeare to
have been the best writer who ever lived.""", 3),

    ("""Shakespeare’s most famous plays include Romeo  
and Juliet, Macbeth, Hamlet, King Lear, Othello,  
and Julius Caesar. Usually, Shakespeare did  
not invent the stories that he told in his plays.  
Instead, he wrote his plays using stories that  
already existed. However, Shakespeare’s plays  
told these stories in a more interesting way  
than ever before. Some of the stories were tragedies,  
some were comedies, and some described historical  
events.""", 3)
]


@pytest.mark.parametrize('input, expected', data)
def test_number_of_articles(input, expected):
    assert expected == get_number_of_articles(input)

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
package string.number_of_articles;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class TestNumberOfArticles {
    @ParameterizedTest
    @CsvSource(delimiter = '|', value = {
            "William Shakespeare was born in the town of Stratford, "
                    + "England, in the year 1564. "
                    + "When he was a young man, "
                    + "Shakespeare moved to the city of London, "
                    + "where he began writing plays. "
                    + "His plays were soon very successful, "
                    + "and were enjoyed both by the common people "
                    + "of London and also by the rich and famous. "
                    + "In addition to his plays, "
                    + "Shakespeare wrote many short poems "
                    + "and a few longer poems. "
                    + "Like his plays, these poems "
                    + "are still famous today."
                    + "|7",
            "Shakespeare?s most famous plays include Romeo "
                    + "and Juliet, Macbeth, Hamlet, King Lear, Othello, "
                    + "and Julius Caesar. Usually, Shakespeare did "
                    + "not invent the stories that he told in his plays. "
                    + "Instead, he wrote his plays using stories that "
                    + "already existed. However, Shakespeare?s plays "
                    + "told these stories in a more interesting way "
                    + "than ever before. Some of the stories were tragedies, "
                    + "some were comedies, and some described historical "
                    + "events."
                    + "|3",
            "There have been many great writers in the history "
                    + "of English literature, but there is no doubt "
                    + "about which writer was the greatest. Many people "
                    + "consider William Shakespeare to have been the "
                    + "best writer who ever lived."
                    + "|3",
            "a a a a a A and An an ana ana aba ab ab The "
                    + "the a a theh the opathe"
                    + "|13",
            "A An The"
                    + "|3"
    }

    )
    void testGetNumberOfArticles(String input, int expected) {
        assertEquals(expected,
                NumberOfArticles.getNumberOfArticles(input));
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
