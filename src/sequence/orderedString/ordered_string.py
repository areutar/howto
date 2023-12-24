def ordered_string(input):
    res = input == ''.join(sorted(input, reverse=True))
    print(res)
