from count_equal_neighbours import *
import pytest


@pytest.mark.parametrize('input, expected', [
    ('abcd', 0),
    ('aabbcc', 3),
    ('aaa', 2),
    ('aaaabbccd', 5),
    ('aaabbaaa', 5)
])
def test_count_equal_neighbours(input, expected):
    assert count_equal_neighbours(input) == expected
