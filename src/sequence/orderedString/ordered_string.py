def ordered_string(input):
    return input == ''.join(sorted(input, reverse=True))
