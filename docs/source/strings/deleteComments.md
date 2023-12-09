### Удаление комментов из кода

На вход подаётся ногострочная строка кода.
Нужно вывести ту же строку(строки), но удалить комментарии и символы пустого пространства в конце строк. 

[Источник](https://stepik.org/lesson/324754/step/8?thread=solutions&unit=307930)

<!-- tabs: start -->
#### **Python**
```python
def delete_comments(text_list):
    comment_sign = '#'
    result = []
    for line in text_list:
        if comment_sign in line:
            index_comment = line.index(comment_sign)
            line = line[:index_comment]
        result.append(line.rstrip())
    return '\n'.join(result)
```

#### **Test Python**
```python
# from __future__ import absolute_import
from src.string.deleteComments.delete_comments import *
import pytest


data = [
    (['''privet(@*)(!$&(%(@)%                           #  wewjf wfmweo qikfwif'''],
     'privet(@*)(!$&(%(@)%'),
    (['print("Введите своё имя")',
      'name = input()',
      'print("Введите пароль, если имеется")    # ахахахах вам не поймать меня',
      'password = input()',
      'if password == "hoover":',
      'print("Здравствуйте, рыцарь", name)         #долой Макнамару',
      'elif password == "noncr":',
      'print("Здравствуйте, паладин", name)',
      'elif password == "gelios":',
      'print("Здравствуйте, старейшина", name)          #Элайджа вперёд',
      'else:',
      'print("Здравствуйте, послушник", name)'
      ],
     ('print("Введите своё имя")\n'
      'name = input()\n'
      'print("Введите пароль, если имеется")\n'
      'password = input()\n'
      'if password == "hoover":\n'
      'print("Здравствуйте, рыцарь", name)\n'
      'elif password == "noncr":\n'
      'print("Здравствуйте, паладин", name)\n'
      'elif password == "gelios":\n'
      'print("Здравствуйте, старейшина", name)\n'
      'else:\n'
      'print("Здравствуйте, послушник", name)')
     ),
    (
        [
            'sampleefnwofewjiefw',
            'wjiefweofiwefinofewnniofweniobiewfibuewf',
            'wiognweifninoewf wefionw oifn oewniffeoiwn wniewfonifewnio',
            'fewkfnweo oiwefnwfiwni oinwefinniwfineiwno',
            'kkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkk'
        ],
        """sampleefnwofewjiefw
wjiefweofiwefinofewnniofweniobiewfibuewf
wiognweifninoewf wefionw oifn oewniffeoiwn wniewfonifewnio
fewkfnweo oiwefnwfiwni oinwefinniwfineiwno
kkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkk"""
    ),
    (
        ['111', '222'],
        '''111\n222'''
    ),
    (
        [
            'kdeaefk                           #tndjwd',
            'awk()()!!!                    #ttttt',
            'fowk',
            'ttttttttt',
            'pewrjwermwk #jelwee',
            'kekekekekekekekekekeke'
        ],
        """kdeaefk
awk()()!!!
fowk
ttttttttt
pewrjwermwk
kekekekekekekekekekeke"""
    )
]


@pytest.mark.parametrize('text_list, expected', data)
def test_delete_comments(text_list, expected):
    assert delete_comments(text_list) == expected

```

#### **Java**

```java
package string.deleteComments;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class DeleteComments {

    public static String deleteComments(String input) {
        String commentsSigns = "//";
        List<String> words = Arrays.stream(input.split("\n"))
                .map(line -> {
                    if (line.contains(commentsSigns)) {
                        line = line.substring(0, line.indexOf(commentsSigns));
                    }
                    return line.stripTrailing();
                })
                .collect(Collectors.toList());
        return String.join("\n", words);
    }

}
```
#### **Test Java**

```java
package string.deleteComments.tests;

import static org.junit.Assert.assertEquals;

import java.util.stream.Stream;
import string.deleteComments.DeleteComments;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

public class TestDeleteComments {
    @ParameterizedTest
    @MethodSource("provideParams")
    void testDeleteComments(String code, String expected) {
        assertEquals(expected, DeleteComments.deleteComments(code));
    }

    private static Stream<Arguments> provideParams() {
        return Stream.of(
                Arguments.of("privet(@*)(!$&(%(@)%                           // wewjf wfmweo qikfwif",
                        "privet(@*)(!$&(%(@)%"),
                Arguments.of("sampleefnwofewjiefw\n" +
                        "wjiefweofiwefinofewnniofweniobiewfibuewf\n" +
                        "wiognweifninoewf wefionw oifn oewniffeoiwn wniewfonifewnio\n" +
                        "fewkfnweo oiwefnwfiwni oinwefinniwfineiwno\n" +
                        "kkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkk",
                        "sampleefnwofewjiefw\n" +
                                "wjiefweofiwefinofewnniofweniobiewfibuewf\n" +
                                "wiognweifninoewf wefionw oifn oewniffeoiwn wniewfonifewnio\n" +
                                "fewkfnweo oiwefnwfiwni oinwefinniwfineiwno\n" +
                                "kkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkk"),
                Arguments.of("print(\"Введите своё имя\")\n" +
                        "name = input()\n" +
                        "print(\"Введите пароль, если имеется\")    //  ахахахах вам не поймать меня\n" +
                        "password = input()\n" +
                        "if password == \"hoover\":\n" +
                        "    print(\"Здравствуйте, рыцарь\", name)         // долой Макнамару\n" +
                        "elif password == \"noncr\":\n" +
                        "    print(\"Здравствуйте, паладин\", name)\n" +
                        "elif password == \"gelios\":\n" +
                        "    print(\"Здравствуйте, старейшина\", name)          // Элайджа вперёд\n" +
                        "else:\n" +
                        "    print(\"Здравствуйте, послушник\", name)",
                        "print(\"Введите своё имя\")\n" +
                                "name = input()\n" +
                                "print(\"Введите пароль, если имеется\")\n" +
                                "password = input()\n" +
                                "if password == \"hoover\":\n" +
                                "    print(\"Здравствуйте, рыцарь\", name)\n" +
                                "elif password == \"noncr\":\n" +
                                "    print(\"Здравствуйте, паладин\", name)\n" +
                                "elif password == \"gelios\":\n" +
                                "    print(\"Здравствуйте, старейшина\", name)\n" +
                                "else:\n" +
                                "    print(\"Здравствуйте, послушник\", name)"),
                                Arguments.of("kdeaefk                           //tndjwd\n" + 
                                        "awk()()!!!                    //ttttt\n" + 
                                        "fowk\n" + 
                                        "ttttttttt\n" + 
                                        "pewrjwermwk //jelwee\n" + 
                                        "kekekekekekekekekekeke",
                                "kdeaefk\n" + 
                                        "awk()()!!!\n" + 
                                        "fowk\n" + 
                                        "ttttttttt\n" + 
                                        "pewrjwermwk\n" + 
                                        "kekekekekekekekekekeke")
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
