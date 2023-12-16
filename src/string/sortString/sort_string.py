def sort_string(input):
    chars = list(input)
    chars.sort(key=ord)
    return "".join(chars)
