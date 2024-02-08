from ramanujan_numbers import get_ramanujan_numbers
from time import time

threshold = 1000
output = ''
start = time()
numbers = get_ramanujan_numbers(threshold)
end = time()
exec_time = int((end - start) * 1000)
output += f'Для чисел меньших {threshold} найдено '\
    f'{len(numbers)} чисел Рамануджана\n'
output += f'Время выполнения - {exec_time}ms\n\n'
with open('./src/numerical/RamanujanNumbers/python_test.txt',
          'w',
          encoding='utf-8') as test_file:
    test_file.write(output)
    for number in numbers:
        test_file.write(str(number) + '\n')

