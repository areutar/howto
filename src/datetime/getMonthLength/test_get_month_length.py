from get_month_length import *
import pytest

data = [
    (1, 31),
    (2, 29),
    (3, 31),
    (11, 30),
    (12, 31)
]


@pytest.mark.parametrize('month, expected', data)
def test_get_month_length(month, expected):
    actual = get_month_length(month)
    assert actual == expected
