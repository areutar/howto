from is_valid_triangle import *
import pytest


@pytest.mark.parametrize('sides, expected', [
    ([2, 2, 2], 'True'),
    ([2, 3, 10], 'False'),
    ([3, 4, 5], 'True'),
    ([10, 11, 12], 'True'),
    ([12, 10, 2], 'False'),
    ([100, 1, 2], 'False')
])
def test_is_valid_triangle(sides, expected, capsys):
    is_valid_triangle(sides)
    captured = capsys.readouterr().out.strip()
    assert captured == expected
