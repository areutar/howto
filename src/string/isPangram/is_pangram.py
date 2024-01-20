from string import ascii_lowercase


def is_pangram(input):
    result = sum([ch in input.lower()
                  for ch in ascii_lowercase]) == 26
    print(result)
