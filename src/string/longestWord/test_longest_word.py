from longest_word import *
import pytest


@pytest.mark.parametrize('input, expected', [
    ('проспал почти всю ночь', 7),
    ('sss fffffff qqqqqq aaaaaaaaaaaaaaaaaaaa qq', 20),
    ('qwerty', 6),
    ('python is awesome', 7),
    ('qqqqqqqqqqqqqqqqqqqqqqqq pppppppppppp', 24),
])
def test_longest_word(input, expected):
    assert longest_word(input) == expected
