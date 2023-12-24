from ordered_string import *
import pytest


@pytest.mark.parametrize('input, expected', [
    ('5321', 'True'),
    ('7820', 'False'),
    ('9663', 'True'),
    ('9876543210', 'True'),
    ('987654329', 'False'),
    ('12345', 'False'),
    ('54332222221111', 'True'),
    ('987654341', 'False'),
    ('98768974321', 'False'),
    ('987654328', 'False'),
    ('111111111', 'True'),
    ('6543211', 'True'),
    ('6593211', 'False')
])
def test_ordered_string(input, expected, capsys):
    ordered_string(input)
    captured = capsys.readouterr().out.rstrip()
    assert captured == expected
