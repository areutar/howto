from check_capitalized import *
import pytest


@pytest.mark.parametrize('input, expected', [
    ('chris alan', False),
    ('Chris alan', False),
    ('chris Alan', False),
    ('Chris Alan', True)
])
def test_check_capitalized(input, expected):
    assert check_capitalized(input) == expected
