from get_initials import get_initials
import pytest


@pytest.mark.parametrize('input, expected',
                         [('Владимир Семенович Высоцкий', 'В.С.В.'),
                          ('Гуев Тимур Ахсарбекович', 'Г.Т.А.'),
                          ('Михаил Иванович Кузнецов', 'М.И.К.')])
def test_get_initials(input, expected):
    assert get_initials(input) == expected
