def longest_word(input):
    return len(max(input.split(), key=len))
