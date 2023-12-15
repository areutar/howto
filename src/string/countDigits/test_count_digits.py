from count_digits import *
import pytest


@pytest.mark.parametrize("input, expected", [
                         ('nezabud dl-6', 1),
                         ('l33t 3301', 6),
                         ('1029384756aaa1234567890', 20),
                         ('jehfkjshfkjsdk90909090', 8)
                         ])
def test_count_digits(input, expected):
    assert count_digits(input) == expected
