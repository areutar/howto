from all_elements_are_the_same import *
import pytest


@pytest.mark.parametrize('input, expected', [
    ('11111', 'YES'),
    ('11112111', 'NO'),
    ('1', 'YES'),
    ('77', 'YES'),
    ('56', 'NO'),
    ('999', 'YES'),
    ('899', 'NO'),
    ('989', 'NO'),
    ('998', 'NO'),
    ('666666666666666', 'YES'),
    ('6666667666666', 'NO'),
    ('177777777777777', 'NO'),
    ('77777777777777771', 'NO'),
    ('9999999999999999999999999999', 'YES'),
    ('1211111', 'NO'),
    ('1237564', 'NO'),
    ('231', 'NO'),
    ('132', 'NO'),
    ('1000000', 'NO')
])
def test_all_elements_are_the_same(input, expected, capsys):
    all_elements_are_the_same(input)
    captured = capsys.readouterr().out.strip()
    assert captured == expected
