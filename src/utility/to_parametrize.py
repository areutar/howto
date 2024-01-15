import pyperclip


def decorate_token(token, wrap):
    result = token
    if wrap:
        result = '\'' + token + "'"
    return result

# забирает из буфера обмена табличные данные (должны быть все непустые),
# и формирует из них список строк для тестирования вида:
# ('bla', 'bla'),
# ..............
# В начале запрашивается ввод количества аргументов, а затем 
# по каждому аргументу, нужно ли оборачивать его в строку: 1 - нужно, 0 - нет

def build_tokens():
    numberArgs = int(input("How many arguments?"))
    need_wraps = [int(input("Обернуть в кавычки аргумент " + str(i + 1) + "? (1/0?)"))
                  for i in range(numberArgs)]
    leftBracket = input("Введите левую скобку")
    rightBracket = input("Введите правую скобку")
    strings = pyperclip.paste().split()
    print(len(strings))
    tokens = []
    for i in range(0, len(strings), numberArgs):
        token = leftBracket
        token += ', '.join([
            decorate_token(strings[i + j], need_wraps[j])
            for j in range(numberArgs)])
        token += rightBracket
        tokens.append(token)

    return ',\n'.join(tokens)


str = build_tokens()
print(str)
pyperclip.copy(str)
