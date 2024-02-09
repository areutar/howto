def is_power_of_two(value):
    result = bin(value).count('1') == 1
    print(result)
