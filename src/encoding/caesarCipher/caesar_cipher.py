ALPHABET_RU = 'АБВГДЕЖЗИЙКЛМНОПРСТУФХЦЧШЩЪЫЬЭЮЯ'
ALPHABET_RU_LOW = 'абвгдежзийклмнопрстуфхцчшщъыьэюя'
ALPHABET_EN = 'ABCDEFGHIJKLMNOPQRSTUVWXYZ'
ALPHABET_EN_LOW = 'abcdefghijklmnopqrstuvwxyz'
ALPHABETS = [ALPHABET_EN, ALPHABET_EN_LOW, ALPHABET_RU, ALPHABET_RU_LOW]
DIRECTIONS = ['вперёд', 'назад']
TRY_AGAIN_MESSAGE = 'Попробуйте ещё раз!\n'
DIRECTIONS_MAP = {'вперёд': 1, 'назад': -1}


def caesar_cipher_encode():
    direction = provide_direction()
    shift = provide_shift(direction)
    text = provide_text()
    return caesar_cipher_code(shift, text)


def caesar_cipher_code(shift, text):
    result = []
    for c in text:
        alphabets = get_alhpabet(c)
        if not alphabets:
            result.append(c)
        else:
            alphabet = get_alhpabet(c)[0]
            alph_index = alphabet.find(c)
            result.append(alphabet[(alph_index + shift) % len(alphabet)])
    return ''.join(result)


def get_alhpabet(ch):
    return [alphbt for alphbt in ALPHABETS if ch in alphbt]


def provide_text():
    return list(input('\nВведите сообщение:\n'))


def provide_direction():
    while True:
        direction = input(
            'Введите направление сдвига(вперёд/назад)\n').strip()
        if direction in DIRECTIONS:
            print()
            return DIRECTIONS_MAP[direction]
        else:
            print('Подходят только слова "вперёд" или "назад"')
            print(TRY_AGAIN_MESSAGE)


def provide_shift(direction):
    while True:
        try:
            shift = int(input('На сколько букв сдвинуть?\n'))
            if shift < 0:
                raise ValueError
            return shift * direction
        except ValueError:
            print('Нужно ввести целое положительное число')
            print(TRY_AGAIN_MESSAGE)
