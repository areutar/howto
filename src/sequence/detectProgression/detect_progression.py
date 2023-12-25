def detect_progression(numbers):
    numbers = sorted(numbers)
    differences = [numbers[i + 1] - numbers[i]
                   for i in range(len(numbers) - 1)]
    print(differences.count(differences[0]) == len(differences))
