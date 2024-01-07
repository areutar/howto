### Делаем срезы

На вход программе подается одна строка. Напишите программу, которая выводит:

1. третий символ этой строки;
2. предпоследний символ этой строки;
3. первые пять символов этой строки;
4. всю строку, кроме последних двух символов;
5. все символы с четными индексами;
6. все символы с нечетными индексами;
7. все символы в обратном порядке;
8. все символы строки через один в обратном порядке, начиная с последнего.

[Источник](https://stepik.org/lesson/302627/step/13?thread=solutions&unit=284520)

На java был написан специальный класс, делающий срезы практически также, как и на python. Но есть и разница. Например, s[1:2], s[1:1],
s[1:2:0] будут все выдавать s[1], а s[1:2:-1] выбросит исключение.

<!-- tabs: start -->
#### **Python**

```python
def making_slices(input):
    [print(input[a:b:c]) for a, b, c in (
        (2, 3, None), (-2, -1, None), (0, 5, None), (0, -2, None),
        (None, None, 2), (1, None, 2), (None, None, - 1), (-1, None, -2))]


st = 'abcdefghijklmnopqrstuvwxyz'
print(st[3::-2])
print(st[3:-2])
print(st[-2:3])
print(st[-2:3:-1])
print(st[2:2])
print(st[2:3:1])
print(st[- 1:])
print(st[::26])
print(st[1:1:])
print(st[None:None:None])
print(st[:1:-2])
print(st[1:2:-1])
```
#### **Test Python**

```python
from making_slices import *
import pytest


@pytest.mark.parametrize('input, expected', [
    ('abcdefghijklmnopqrstuvwxyz',
     """c
y
abcde
abcdefghijklmnopqrstuvwx
acegikmoqsuwy
bdfhjlnprtvxz
zyxwvutsrqponmlkjihgfedcba
zxvtrpnljhfdb"""),
    ('The weak can never forgive. '
     'Forgiveness is the attribute of the strong',
        """e
n
The w
The weak can never forgive. Forgiveness is the attribute of the stro
Tewa a ee ogv.Frieesi h trbt ftesrn
h ekcnnvrfrie ogvns steatiueo h tog
gnorts eht fo etubirtta eht si ssenevigroF .evigrof reven nac kaew ehT
got h oeuitaets snvgo eirfrvnncke h"""
     ),
    ('There is no such thing as an accident. '
     'What we call by that name is the effect of some cause '
     'which we do not see',
     """e
e
There
There is no such thing as an accident. What we call by that name is the effect of some cause which we do not s
Teei osc hn sa ciet htw alb htnm steefc fsm as hc ed o e
hr sn uhtiga nacdn.Wa ecl yta aei h feto oecuewihw ontse
ees ton od ew hcihw esuac emos fo tceffe eht si eman taht yb llac ew tahW .tnedicca na sa gniht hcus on si erehT
estno whiweuceo otef h iea aty lce aW.ndcan agithu ns rh"""
     ),
    ('Success is the ability to go from failure to failure'
     ' without losing your enthusiasm',
     """c
s
Succe
Success is the ability to go from failure to failure without losing your enthusia
Scesi h blt og rmfiuet alr ihu oigyu nhsam
ucs steaiiyt ofo alr ofiuewtotlsn oretuis
msaisuhtne ruoy gnisol tuohtiw eruliaf ot eruliaf morf og ot ytiliba eht si sseccuS
mashn uygio uhi rla teuifmr go tlb h isecS"""
     )
])
def test_making_slices(input, expected, capsys):
    making_slices(input)
    captured = capsys.readouterr().out.strip()
    assert captured == expected

```

#### **Java**

```java
package sequence.makingSlices;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Slicer {

	public static final String LIST_IS_NULL = "List is null!";

	public static void main(String[] args) {
		String alphabet = "abcdefghijklmnopqrstuvwxyz";
		Slicer slicer = new Slicer();
		System.out.println(slicer.slice(alphabet, 2, 3, null));
		System.out.println(slicer.slice(alphabet, -2, -2, null));
		System.out.println(slicer.slice(alphabet, null, 5, null));
		System.out.println(slicer.slice(alphabet, null, -2, null));
		System.out.println(slicer.slice(alphabet, null, null, 2));
		System.out.println(slicer.slice(alphabet, 1, null, 2));
		System.out.println(slicer.slice(alphabet, null, null, -1));
		System.out.println(slicer.slice(alphabet, null, null, -2));
	}

	public String slice(String input, Integer start,
			Integer end, Integer step) {
		List<String> chars = input.chars()
				.mapToObj(i -> String.valueOf((char) i))
				.collect(Collectors.toList());
		return String.join(
				"", slice(
						chars, start, end, step));
	}

	public <T> List<T> slice(List<T> list, Integer start,
			Integer end, Integer step) {

		if (list == null) {
			throw new IllegalArgumentException(LIST_IS_NULL);
		}

		if (list.isEmpty()) {
			return list;
		}

		RangeConfigurator configurator = new RangeConfigurator(start, end, step, list.size());

		int cStart = configurator.getStart();
		int cEnd = configurator.getEnd();
		int cStep = configurator.getStep();
		return IntStream.iterate(cStart,
				i -> (cStart <= cEnd && i <= cEnd - 1)
						|| (cStart >= cEnd && i >= cEnd + 1),
				i -> i + cStep)
				.mapToObj(list::get)
				.collect(Collectors.toList());
	}
}
```
[full code](https://github.com/areutar/howto/blob/main/src/sequence/makingSlices/Slicer.java)

#### **Test Java**
Тесты гененировались с помощью написанного специально генератора тестов:
[TestGenerator](https://github.com/areutar/howto/blob/main/src/utility/TestGenerator.java)

[Код тестов](https://github.com/areutar/howto/blob/main/src/sequence/makingSlices/TestSlicer.java)

#### **JavaScript**

```javascript

```
#### **Test JavaScript**

```javascript

```
<!-- tabs: end -->
