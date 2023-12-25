from detect_progression import *
import pytest


@pytest.mark.parametrize('input, expected', [
    ([1, 2], 'True'),
    ([2, 1], 'True'),
    ([1, 2, 3], 'True'),
    ([0, -3, 3, -6], 'True'),
    ([18, 15, 6, 9, 12, 3, 0], 'True'),
    ([1, 2, 4], 'False'),
    ([1, 2, 3, 2], 'False'),
    ([1, 2, 3, 5], 'False'),
    ([2, 4, 8], 'False'),
    ([10, 5, 0], 'True'),
    ([1, 1, 1, 1, 1, 1], 'True'),
    ([1000, 2000, 3000], 'True'),
    ([25, 125, 224], 'False'),
])
def test_detect_progression(input, expected, capsys):
    detect_progression(input)
    captured = capsys.readouterr().out.rstrip()
    assert captured == expected
