from ramanujan_numbers import get_ramanujan_numbers
from time import time

thresholds = [50, 100, 150]
output = ''
for threshold in thresholds:
    start = time()
    numbers = get_ramanujan_numbers(threshold)
    end = time()
    exec_time = int((end - start) * 1000)
    output += f'Для чисел меньших {threshold} найдено '\
        f'{len(numbers)} чисел Рамануджана\n'
    output += f'Время выполнения - {exec_time}ms\n\n'
print(output)
