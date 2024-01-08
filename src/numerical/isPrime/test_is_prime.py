from is_prime import *
import pytest


@pytest.mark.parametrize('input, expected', [
    ('1', 'False'),
    ('10', 'False'),
    ('2', 'True'),
    ('17', 'True'),
    ('101', 'True'),
    ('100', 'False'),
    ('360000', 'False'),
    ('121', 'False')
])
def test_is_prime(input, expected, capsys):
    is_prime(input)
    captured = capsys.readouterr().out.strip()
    assert captured == expected
