def get_ramanujan_numbers(threshold):
    sums = {}
    result = {}

    for i in range(threshold):
        for j in range(i + 1, threshold):
            current = i ** 3 + j ** 3
            if current in sums:
                sums[current] = sums[current] + [i, j]
            else:
                sums[current] = [i, j]

    for sum, args in sums.items():
        if len(args) > 2:
            result[sum] = args

    sorted_result = sorted(result.items())
    return sorted_result


# первое число, раскладываемое в сумму кубов тремя способами 87539319
[87539319, 167, 436, 228, 423, 255, 414]
