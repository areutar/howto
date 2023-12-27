from swap_min_and_max import *
import pytest


@pytest.mark.parametrize('input, expected', [
    ('3 4 5 2 1', '3 4 1 2 5'),
    ('10 9 8 7 6 5 4 3 2 1', '1 9 8 7 6 5 4 3 2 10'),
    ('1 2', '2 1'),
    ('1', '1'),
    ('1 1 1 1 1', '1 1 1 1 1'),
    ('2 1', '1 2'),
    ('2 1 1', '1 2 2'),
    ('1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16 17 180 19 20 21 22',
        '180 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16 17 1 19 20 21 22'),
    ('1 2 3 4 5 6 7 8 9 10', '10 2 3 4 5 6 7 8 9 1'),
    ('1 5 4 3 2', '5 1 4 3 2'),
])
def test_swap_min_and_max(input, expected, capsys):
    swap_min_and_max(input)
    captured = capsys.readouterr().out.strip()
    assert captured == expected
