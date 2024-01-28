import re
from string import ascii_lowercase
from string import ascii_uppercase

ALPHABETS = [ascii_lowercase, ascii_uppercase]


def caesar_cipher2(text):
    founds = re.finditer('\w+', text)
    for found in founds:
        word = found.group()
        encoded_word = caesar_cipher_code(len(word), word)
        text = text.replace(word, encoded_word, 1)
    return text


def caesar_cipher_code(shift, text):
    result = []
    for c in text:
        alphabets = get_alphabet(c)
        if alphabets:
            alphabet = get_alphabet(c)[0]
            alphabet_index = alphabet.find(c)
            result.append(alphabet[(alphabet_index + shift) % len(alphabet)])
        else:
            result.append(c)
    return ''.join(result)


def get_alphabet(ch):
    return [alphabet for alphabet in ALPHABETS if ch in alphabet]


# text = input()
# print(caesar_cipher2(text))
