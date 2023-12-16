from sort_string import *
import pytest


@pytest.mark.parametrize('input, expected', [
    ('', ''),
    ('a', 'a'),
    ('ab', 'ab'),
    ('a!a', '!aa'),
    ('a b', ' ab'),
    ('ba b', ' abb'),
    ('ёе', 'её')
])
def test_sort_string(input, expected):
    assert sort_string(input) == expected
