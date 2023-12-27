### Создать копию списка

Создать копию списка так, чтобы при изменении оригинального списка, копия не менялась.

<!-- tabs: start -->
#### **Python**

```python

METHOD                TIME TAKEN
b = [*a]               2.75180600000021
b = a * 1              3.50215399999990
b = a[:]               3.78278899999986  # Python 2 winner (see above)
b = a.copy()           4.20556500000020  # Python 3 "slice equivalent" (see above)
b = []; b.extend(a)    4.68069800000012
b = a[0:len(a)]        6.84498999999959
*b, = a                7.54031799999984
b = list(a)            7.75815899999997
b = [i for i in a]    18.4886440000000
b = copy.copy(a)      18.8254879999999
b = []
for item in a:
  b.append(item)      35.4729199999997
```
[Источник](https://stackoverflow.com/questions/2612802/how-do-i-clone-a-list-so-that-it-doesnt-change-unexpectedly-after-assignment)

#### **Java**

```java
List<Integer> copy = new ArrayList<>(list);

List<Integer> copy = new ArrayList<>();
copy.addAll(list);

List<Integer> source = Arrays.asList(1, 2, 3);
List<Integer> dest = Arrays.asList(5, 6, 7, 8, 9, 10);
Collections.copy(dest, source);

List<String> copy = list.stream()
  .collect(Collectors.toList());

List<T> copy = List.copyOf(list);

```
[Источник](https://www.baeldung.com/java-copy-list-to-another "baeldung")

#### **JavaScript**

```javascript

```
<!-- tabs: end -->
