def is_correct_brackets2(input):
    ROUND_BRACKETS = '()'
    SQUARE_BRACKETS = '[]'
    CURLY_BRACKETS = '{}'
    brackets_pairs = [ROUND_BRACKETS, SQUARE_BRACKETS, CURLY_BRACKETS]
    BRACKETS = '([{}])'
    only_brackets = ''.join([ch for ch in input if ch in BRACKETS])
    while ROUND_BRACKETS in only_brackets \
        or SQUARE_BRACKETS in only_brackets \
            or CURLY_BRACKETS in only_brackets:
        for bracket_pair in brackets_pairs:
            if bracket_pair in only_brackets:
                only_brackets = only_brackets.replace(bracket_pair, "")
    result = not only_brackets
    print(result)
