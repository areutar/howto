from sys import stdout
import tkinter as tk


def getClipoard():
    root = tk.Tk()
    root.withdraw()  # keep the window from showing
    str = root.clipboard_get()
    return str.split()


def decorate_token(token):
    return '\'' + token + "'"

# забирает из буфера обмена табличные данные (должны быть все непустые),
# и формирует из них список строк для тестирования вида:
# ('bla', 'bla'),
# ..............
def build_data():
    tokens = getClipoard()
    for i in range(0, len(tokens), 2):
        print('('
              + decorate_token(tokens[i])
              + ', '
              + decorate_token(tokens[i + 1])
              + '),'
              )


build_data()
