### Сортировка списка

Встроенные способы сортировки списка.

<!-- tabs: start -->
#### **Python**

```python
a = ['бета', 'альфа', 'дельта', 'гамма']
a.sort()

В обратном порядке: 
1. a.sort(reverse=True)

2. a.sort()
a.reverse()
```
[Источник](https://stepik.org/lesson/324754/step/9?unit=307930)

#### **Java**

```java
1. Collections.sort(courses);

2. courses.sort(null);

3.   List<Course> sortedCourses = courses.stream()
    .sorted()
    .collect(Collectors.toList());

В обратном порядке:
1. Collections.sort(courses, Comparator.reverseOrder());

2. Collections.sort(courses);
Collections.reverse(courses);

3. courses.sort(Comparator.reverseOrder());

4. List<Course> reverseSortedCourses = courses.stream()
        .sorted(Comparator.reverseOrder())
        .collect(Collectors.toList());
            
Если класс  не имплементирует Comparable:

1. Using Collections sort utility
We cannot use this as the type of the objects must implement Comparable.

2. Using sort method on the List
Pass a comparator that orders the cars by the model name.
cars.sort(Comparator.comparing(Car::getModel));

3. Sorting when streaming
Pass the same comparator to the sorted method.
List<Car> sortedCars = cars.stream()
        .sorted(Comparator.comparing(Car::getModel))
        .collect(Collectors.toList());

```
[Источник](https://javadevcentral.com/three-ways-to-sort-a-list-in-java)

#### **JavaScript**

```javascript

```

<!-- tabs: end -->
