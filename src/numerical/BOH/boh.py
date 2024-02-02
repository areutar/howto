from tkinter import *
from tkinter.messagebox import showwarning
from tkinter.ttk import Radiobutton

NUMBER_SYSTEMS = [
    ('двоичная', 2, bin),
    ('восьмеричная', 8, oct),
    ('десятичная', 10, int),
    ('шестнадцатиричная', 16, hex)]
FROM_WHICH_SYSTEM = 'Из какой системы счисления переводим?'
TO_WHICH_SYSTEM = 'В какую систему счисления переводим?'


def boh(input):
    number = int(input)
    print(bin(number)[2:])
    print(oct(number)[2:])
    print(hex(number).upper()[2:])


def add_rbuttons(row_, selected):
    r_buttons = [Radiobutton(
        window,
        padding=15,
        text=NUMBER_SYSTEMS[i][0],
        value=i,
        variable=selected)
        for i in range(4)]
    r_buttons[0].grid(row=row_, column=0)
    r_buttons[1].grid(row=row_, column=1)
    r_buttons[2].grid(row=row_, column=2, columnspan=2)
    r_buttons[3].grid(row=row_, column=4, columnspan=2)


def add_big_label(row_, text_):
    label = Label(
        window,
        text=text_
    )
    label.grid(
        row=row_, column=0, columnspan=4, sticky=W, padx=5, pady=5
    )
    return label


def convert():
    from_system = source_selected.get()
    input_str = input_number_field.get()
    to_system = target_selected.get()

    try:
        int_number = int(input_str, NUMBER_SYSTEMS[from_system][1])
    except ValueError:
        showwarning(
            'Предупреждение',
            f"""Ваше число {input_str} не может быть числом в системе
            по основанию {NUMBER_SYSTEMS[from_system][1]}""")
        return

    if to_system == 2:
        result = int_number
    else:
        result = NUMBER_SYSTEMS[to_system][2](int_number)[2:]

    result_field.delete(0, END)
    result_field.insert(0, result)


window = Tk()
window.title('Конвертер систем счисления')
window.geometry('600x300')

# grid lvl 0
choose_source_sistem_label = add_big_label(0, FROM_WHICH_SYSTEM)

# grid lvl 1
source_selected = IntVar(value=3)
add_rbuttons(1, source_selected)

# grid lvl 2
input_label = Label(window, text='Введите число:', padx=5, pady=20)
input_label.grid(row=2, column=0)

input_number_field = Entry(window, validate='focusout', width=10)
input_number_field.grid(row=2, column=1)
input_number_field.focus()

# grid lvl 3
choose_label = add_big_label(3, TO_WHICH_SYSTEM)

# grid lvl 4
target_selected = IntVar(value=2)
add_rbuttons(4, target_selected)

# grid lvl 5
btn_convert = Button(window, text='Перевести', command=convert,)
btn_convert.grid(row=5, column=0, padx=10, pady=5, sticky=W)

result_field = Entry(window, width=10)
result_field.grid(row=5, column=1)

window.mainloop()
