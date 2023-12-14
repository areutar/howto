def most_frequent_symbol(input):
    max_frequency = 0
    sign_frequent = ''
    symbols = []
    for c in input:
        if c in symbols:
            continue
        symbols.append(c)
        current_frequency = input.count(c)
        if current_frequency >= max_frequency:
            max_frequency = current_frequency
            sign_frequent = c
    return sign_frequent
