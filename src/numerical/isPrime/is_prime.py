def is_prime(num):
    num = int(num)
    dividers = [i for i in range(2, num + 1) if num % i == 0]
    result =  len(dividers) == 1
    print(result)
