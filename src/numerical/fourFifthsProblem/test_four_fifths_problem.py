from four_fifths_problem import *
from time import time

start = time()
result = four_fifths_problem(150)
end = time()
elapsed = int((end - start) * 1000)
print(f'Время выполнения {elapsed}ms')
print(result)

'Время выполнения 16183ms'
[[27, 84, 110, 133, 144]]