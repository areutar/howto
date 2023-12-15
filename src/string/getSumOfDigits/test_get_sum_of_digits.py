from get_sum_of_digits import *
import pytest


@pytest.mark.parametrize('input, expected', [
    ('2514', 12),
    ('12', 3),
    ('12345', 15),
    ('7777777777', 70)
])
def test_get_sum_of_digits(input, expected):
    assert get_sum_of_digits(input) == expected
