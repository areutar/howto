### Методы строк

## **композиция и декомпозиция**

## - сложение

\+ — оператор конкатенации строк. Он возвращает строку, состоящую из совокупности других строк. 

## - умножение

\* — оператор создает несколько копий строки. Если str это строка, а n целое число, то будет создано n копий строки str. 

<!-- tabs: start -->
#### **Python**

```python
>>> str = 'Строка'
>>> print(5 * str)
'СтрокаСтрокаСтрокаСтрокаСтрока'
```
#### **Java**

```java
Strint s = "Строка";
System.out.println(s.repeat(5));
```
#### **JavaScript**

```javascript

```
<!-- tabs: end -->
## - join

Возвращает строку, собранную из элементов указанного объекта, поддерживающего итерирование(например, список строк).
<!-- tabs: start -->

#### **Python**

```python
x.join(iterable)
```
#### **Java**

```java
String str = "abcd";
str = String.join(" ", str.split(""));
```
#### **JavaScript**

```javascript

```
<!-- tabs: end -->
## - split

Разбивает строку s на части, используя специальный разделитель x, и возвращает эти части в виде списка.

<!-- tabs: start -->

#### **Python**
```python
s.split(x)
```
#### **Java**

```java
str.split("\\s+")
```
#### **JavaScript**

```javascript

```
<!-- tabs: end -->

## - partition

Принимает в качестве аргумента разделитель x (любой символ, букву или цифру). Слева-направо ищет в строке s первый встречающийся разделитель х и в месте разделителя разрезает строку на 3 части: 1) голову(часть строки до разделителя), 2) разделитель и 3) хвост(часть строки после разделителя). Метод возвращает кортеж(tuple), состоящий из трех элементов (голова, разделитель, хвост)

<!-- tabs: start -->
#### **Python**

```python
s.partition(x)
```
#### **Java**

```java

```
#### **JavaScript**

```javascript

```
<!-- tabs: end -->

## **для работы с регистром**

## - capitalize

Преобразует первую букву первого слова строки s в букву в верхнем регистре, все остальные буквы преобразуются в буквы в нижнем регистре.

<!-- tabs: start -->
#### **Python**

```python
s.capitalize()
```
#### **Java**

```java
return str.substring(0, 1).toUpperCase() +
    str.substring(1)
```
#### **JavaScript**

```javascript

```
<!-- tabs: end -->

## - title

Преобразует первые буквы всех слов строки s в буквы верхнего регистра, все остальные буквы слов преобразует в буквы нижнего регистра.

<!-- tabs: start -->
#### **Python**

```python
s = "1ab1ab1ab1a-b1"
print(s.title())
>>1Ab1Ab1Ab1A-B1

```
#### **Java**

```java
public static String title(String text) {
    Pattern alnum = Pattern.compile("\\b\\p{IsAlphabetic}+\\b");
    Matcher matcher = alnum.matcher(text);
    return matcher.replaceAll(t -> t.group().substring(0, 1).toUpperCase() +
        t.group().substring(1).toLowerCase());
  }
// не работает так же, как в python, на строках с uncased символами
```
#### **JavaScript**

```javascript

```
<!-- tabs: end -->

## - upper

Преобразует все буквы строки s в буквы верхнего регистра.

<!-- tabs: start -->
#### **Python**

```python
s.upper()
```
#### **Java**

```java
toUpperCase()
```
#### **JavaScript**

```javascript

```
<!-- tabs: end -->

## - lower

Преобразует все буквы строки s в буквы нижнего регистра.

<!-- tabs: start -->
#### **Python**

```python
s.lower()
```
#### **Java**

```java
toLowerCase()
```
#### **JavaScript**

```javascript

```
<!-- tabs: end -->

## - swapcase

Преобразует все буквы верхнего регистра в буквы нижнего регистра, а буквы нижнего регистра преобразует в буквы верхнего регистра.

<!-- tabs: start -->
#### **Python**

```python
s.swapcase()
```
#### **Java**

```java
public static String capitalize(String text) {
    return text.chars()
        .mapToObj(i -> (char) i)
        .map(F::swapChar)
        .map(String::valueOf)
        .collect(Collectors.joining());
  }

public static char swapChar(char c) {
    return Character.isUpperCase(c) ? Character.toLowerCase(c) : Character.toUpperCase(c);
  }
```
#### **JavaScript**

```javascript

```
<!-- tabs: end -->

## - isupper

Возвращает True, если все символы в строке, поддерживающие приведение к регистру, имеют верхний регистр и имеется хотя бы один такой символ, в противном случае — False.

<!-- tabs: start -->
#### **Python**

```python
s.isupper()
```
#### **Java**

```java
String upper = "ЁЁЁ";
System.out.println(upper.matches("\\p{Lu}+"));
```
#### **JavaScript**

```javascript

```
<!-- tabs: end -->

## - islower

Возвращает True, если все символы в строке, поддерживающие приведение к регистру, имеют нижний регистр и имеется хотя бы один такой символ, в противном случае — False.

<!-- tabs: start -->
#### **Python**

```python
s.islower()
```
#### **Java**

```java
String lower = "ёёё";
System.out.println(lower.matches("\\p{Ll}+"));
```
#### **JavaScript**

```javascript

```
<!-- tabs: end -->

## - istitle

Определяет, начинаются ли слова строки с заглавной буквы. Возвращает True, когда s не пустая строка и первый алфавитный символ каждого слова в верхнем регистре, а все остальные буквенные символы в каждом слове строчные. Иначе - False.

<!-- tabs: start -->
#### **Python**

```python
s.istitle()
```
#### **Java**

```java
 public static boolean isTitle(String input) {
        return Arrays.stream(input.split("\\s+"))
                .allMatch(Sample::isTitledWord);
    }

    public static boolean isTitledWord(String word) {
        return Arrays.stream(word.split("\\s+"))
                .allMatch(s -> {
                    return s.substring(1).chars()
                            .mapToObj(i -> (char) i)
                            .allMatch(Character::isLowerCase)
                            && Character.isUpperCase(s.charAt(0));
                });
    }
    // работает как в python, только если все символы cased
```
#### **JavaScript**

```javascript

```
<!-- tabs: end -->

## **поиск и замена**

## - startswith

Возвращает True, если строка s начинается с указанного префикса, иначе - False.

<!-- tabs: start -->
#### **Python**

```python
s.startswith(prefix)
```
#### **Java**

```java
str.startsWith(substring);
```
#### **JavaScript**

```javascript

```
<!-- tabs: end -->

## - endswith

Возвращает True, если строка s оканчивается указанным постфиксом, иначе - False.

<!-- tabs: start -->
#### **Python**

```python
s.endswith(suffix)
```
#### **Java**

```java
str.endsWith(substring);
```
#### **JavaScript**

```javascript

```
<!-- tabs: end -->

## - find/rfind

Находит в строке s подстроку sub. Возвращает индекс первого(последнего) вхождения искомой подстроки. Если же подстрока не найдена, то метод возвращает значение -1.

<!-- tabs: start -->
#### **Python**

```python
s.find(sub)
s.rfind(sub)
```
#### **Java**

```java
str.indexOf(substring);
str.lastIndexOf(substring);
```
#### **JavaScript**

```javascript

```
<!-- tabs: end -->

## - index/rindex

Находит в строке s подстроку sub. Возвращает индекс первого(последнего) вхождения искомой подстроки. Если же подстрока не найдена, вызывает исключение.

<!-- tabs: start -->
#### **Python**

```python
s.index(substring)
s.rindex(substring)
```
#### **Java**

```java
str.indexOf(substring);
str.lastIndexOf(substring);
```
#### **JavaScript**

```javascript

```
<!-- tabs: end -->
## - replace

Заменяет в строке s все вхождения подстроки old на подстроку new.

<!-- tabs: start -->
#### **Python**

```python
s.replace(old, new)
```
#### **Java**

```java
s.replace(шило, мыло)
```
#### **JavaScript**

```javascript

```
<!-- tabs: end -->

## - strip/lstrip/rstrip

Метод strip() возвращает копию строки s у которой удалены все пробелы стоящие, как в начале (lstrip), так и конце(rstpip) строки.

<!-- tabs: start -->
#### **Python**

```python
s.strip()
s.lstrip()
s.rstrip()
```
#### **Java**

```java
str.strip()
str.stripLeading()
str.stripTrailing()
```
#### **JavaScript**

```javascript

```
<!-- tabs: end -->

## **классификация строк**

## - isalnum

Метод isalnum() определяет, состоит ли исходная строка из буквенно-цифровых символов. Метод возвращает значение True если исходная строка является непустой и состоит только из буквенно-цифровых символов и False в противном случае.

<!-- tabs: start -->
#### **Python**

```python
s.isalnum()
```
#### **Java**

```java
String input = "3ё";
System.out.println(input.matches("[\\p{N}\\p{L}]+"));
```
#### **JavaScript**

```javascript

```
<!-- tabs: end -->

## - isalpha

Метод isalpha() определяет, состоит ли исходная строка из буквенных символов. Метод возвращает значение True если исходная строка является непустой и состоит только из буквенных символов и False в противном случае.

<!-- tabs: start -->
#### **Python**

```python
s.isalpha()
```
#### **Java**

```java
String input = "её";
System.out.println(input.matches("\\p{L}+"));
```
#### **JavaScript**

```javascript

```
<!-- tabs: end -->

## - isascii

Возвращает True, если строка пуста или все символы в ней являются ASCII, в противном случае — False. Символы ASCII имеют кодовые точки в диапазоне от U+0000 до U+007F.

<!-- tabs: start -->
#### **Python**

```python
s.isascii()
```
#### **Java**

```java
String ascii = "sdF .j!35d";
System.out.println(ascii.matches("\\p{ASCII}+"));
```
#### **JavaScript**

```javascript

```
<!-- tabs: end -->

## - isnumeric

Возвращает True, если все символы в строке являются цифрами и имеется хотя бы один символ, в противном случае — False. Числовые символы включают в себя цифровые символы и все символы, имеющие свойство числового значения Юникода, например U+2155, Обычная дробь одна пятая. Формально числовыми символами являются символы со значением свойства Numeric_Type=Digit, Numeric_Type=Decimal или Numeric_Type=Numeric. (p{N} = p{Nd} + p{Nl} + p{No})

<!-- tabs: start -->
#### **Python**

```python
s.isnumeric()
```
#### **Java**

```java
String input = "Ⅷ";
System.out.println(input.matches("\\p{N}+"));
```
#### **JavaScript**

```javascript

```
<!-- tabs: end -->

## - isdigit

Возвращает True, если все символы в строке являются цифрами и имеется хотя бы один символ, в противном случае — False. Цифры включают десятичные символы и цифры, требующие специальной обработки, например цифры верхнего индекса совместимости. Сюда входят цифры, которые нельзя использовать для образования чисел по основанию 10, например числа Харости. Формально цифра — это символ, имеющий значение свойства Numeric_Type=Digit или Numeric_Type=Decimal.

<!-- tabs: start -->
#### **Python**

```python
s.isdigit()
```
#### **Java**

```java
String input = "⁰³⁸";
System.out.println(input.matches("[\\p{Nd}\\p{No}]+"));
```
#### **JavaScript**

```javascript

```
<!-- tabs: end -->

## - isdecimal

Возвращает True, если все символы в строке являются десятичными символами и имеется хотя бы один символ, в противном случае — False. Десятичные символы — это те, которые можно использовать для формирования чисел по основанию 10, например. U + 0660, АРАБСКАЯ-ИНДИЙСКАЯ ЦИФРА НОЛЬ. Формально десятичный символ — это символ общей категории Юникода «Nd».

<!-- tabs: start -->
#### **Python**

```python
s.isdecimal()
```
#### **Java**

```java
String input = "𝟘𝟙𝟚𝟛𝟜𝟝𝟞𝟟𝟠𝟡";
System.out.println(input.matches("\\p{Nd}+"));
```
#### **JavaScript**

```javascript

```
<!-- tabs: end -->

## - isspace

Возвращает True, если в строке есть только пробельные символы и есть хотя бы один символ, в противном случае — False.

<!-- tabs: start -->
#### **Python**

```python
s.isspace()
```
#### **Java**

```java
System.out.println("\t\f\n\r".isBlank());
```
#### **JavaScript**

```javascript

```
<!-- tabs: end -->

## **форматирование строк**

## - rjust/ljust

Метод rjust() используется для выравнивания строки по правому(левому) краю. Он добавляет пробелы в начало(конец) строки, чтобы ее длина стала равной указанной ширине, а затем возвращает полученную строку.

<!-- tabs: start -->
#### **Python**

```python
s.rjust(width[, fillchar])
```
#### **Java**

```java

```
#### **JavaScript**

```javascript

```
<!-- tabs: end -->

## - center

Метод сenter() используется для выравнивания строки по центру путём заполнения полей слева и справа от строки повторяющимся символом, по умолчанию, пробелом.

<!-- tabs: start -->
#### **Python**

```python
s.center(width[, fillchar])
```
#### **Java**

```java

```
#### **JavaScript**

```javascript

```
<!-- tabs: end -->

## - % оператор

## - format

## - f-string

## - Template Class

[Все методы](https://docs.python.org/3/library/stdtypes.html#str.isnumeric)

[Ещё описание](https://smartiqa.ru/courses/python/lesson-4)

[Методы со степика](https://stepik.org/lesson/296416/step/1?unit=278136)

[Форматирование](https://www.geeksforgeeks.org/string-formatting-in-python/)

[Числовые типы](https://stackoverflow.com/questions/44891070/whats-the-difference-between-str-isdigit-isnumeric-and-isdecimal-in-pyth)
