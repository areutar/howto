def all_elements_are_the_same(input):
    result = 'NO'
    if min(input) == max(input):
        result = 'YES'
    print(result)
