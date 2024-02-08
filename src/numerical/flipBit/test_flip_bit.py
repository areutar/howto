from flip_bit import *
import pytest

data = [
    (1, 1, 0),
    (0, 1, 1),
    (0b11, 1, 0b10),
    (0b10, 1, 0b11),
    (0b10, 2, 0),
    (0b11111111, 4, 0b11110111)
]


@pytest.mark.parametrize('value, bit_index, expected', data)
def test_flip_bit(value, bit_index, expected):
    actual = flip_bit(value, bit_index)
    assert actual == expected
