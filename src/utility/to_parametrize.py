import pyperclip


def decorate_token(token):
    return '\'' + token + "'"

# забирает из буфера обмена табличные данные (должны быть все непустые),
# и формирует из них список строк для тестирования вида:
# ('bla', 'bla'),
# ..............
def build_tokens():
    strings = pyperclip.paste().split()
    tokens = []
    for i in range(0, len(strings), 2):
        tokens.append(
            '(' + decorate_token(strings[i]) + ', '
            + decorate_token(strings[i + 1]) + ')'
        )
    return ',\n'.join(tokens)

str = build_tokens()
print(str)
pyperclip.copy(str)

