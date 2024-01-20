def getSumOfCubes(threshold):
    amounts = []
    for i in range(threshold):
        for j in range(threshold):
            if i >= j:
                continue
            else:
                amounts.append((i, j, i ** 3 + j ** 3))
    return amounts


def get_ramanujan_numbers(threshold):
    amounts = getSumOfCubes(threshold)
    ramanujan_numbers = []
    for i, j, sum1 in amounts:
        for k, l, sum2 in amounts:
            if sum1 == sum2 and i != k:
                ramanujan_numbers.append((i, j, sum1))
    ramanujan_numbers.sort(key=lambda x: x[2])
    return ramanujan_numbers
