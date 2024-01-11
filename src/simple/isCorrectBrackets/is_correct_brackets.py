def is_correct_brackets(input):
    count = 0
    for ch in input:
        if ch == '(':
            count += 1
        if ch == ')':
            count -= 1
        if count < 0:
            break
    print(count == 0)
