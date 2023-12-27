def swap_min_and_max(string):
    numbers = string.split()
    mn = min(numbers, key=int)
    mx = max(numbers, key=int)
    for i in range(len(numbers)):
        if numbers[i] == mn:
          numbers[i] = mx
        elif numbers[i] == mx:
          numbers[i] = mn
    print(*numbers)
