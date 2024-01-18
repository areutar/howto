from get_local_name_of_month import *
import pytest


@pytest.mark.parametrize('lang, number, expected', [
    ('ru', 1, 'январь'),
    ('ru', 2, 'февраль'),
    ('ru', 3, 'март'),
    ('ru', 4, 'апрель'),
    ('ru', 5, 'май'),
    ('ru', 6, 'июнь'),
    ('ru', 7, 'июль'),
    ('ru', 8, 'август'),
    ('ru', 9, 'сентябрь'),
    ('ru', 10, 'октябрь'),
    ('ru', 11, 'ноябрь'),
    ('ru', 12, 'декабрь'),
    ('en', 1, 'january'),
    ('en', 2, 'february'),
    ('en', 3, 'march'),
    ('en', 4, 'april'),
    ('en', 5, 'may'),
    ('en', 6, 'june'),
    ('en', 7, 'july'),
    ('en', 8, 'august'),
    ('en', 9, 'september'),
    ('en', 10, 'october'),
    ('en', 11, 'november'),
    ('en', 12, 'december')
])
def test_get_local_name_of_month(lang, number, expected, capsys):
    get_local_name_of_month(lang, number)
    captured = capsys.readouterr().out.strip()
    assert captured == expected
