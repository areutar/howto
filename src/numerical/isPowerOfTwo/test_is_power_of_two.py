from is_power_of_two import *
import pytest


@pytest.mark.parametrize('value, expected', [
    (0, 'False'),
    (1, 'True'),
    (2, 'True'),
    (-2, 'True'),
    (63, 'False'),
    (-256, 'True'),
    (1073741824, 'True'),
    (-2147483648, 'True')
])
def test_is_power_of_two(value, expected, capsys):
    is_power_of_two(value)
    captured = capsys.readouterr().out.strip()
    assert captured == expected
