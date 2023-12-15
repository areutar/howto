from string import ascii_lowercase


def count_lower(str):
    return len([c for c in str if c in ascii_lowercase])
