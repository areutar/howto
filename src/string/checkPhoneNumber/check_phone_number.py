PREFIX = '7'
TOKENS_DELIMITER = '-'


def check_number(number):
    if str(number).startswith(PREFIX + TOKENS_DELIMITER):
        number = number[2:]
    return check_unprefixed_number(number)


def check_unprefixed_number(number):
    tokens = [n for n in number.split(TOKENS_DELIMITER)]
    lengths = [len(n) for n in tokens]
    decimals = [n for n in tokens if n.isdecimal()]
    return lengths == [3, 3, 4] and len(decimals) == 3
