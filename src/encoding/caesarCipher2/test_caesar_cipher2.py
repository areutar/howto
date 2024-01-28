from caesar_cipher2 import caesar_cipher2
import pytest

data = [
    ('Day, mice. "Year" is a mistake!',
        'Gdb, qmgi. "Ciev" ku b tpzahrl!'),
    ('my name is Python!',
        'oa reqi ku Veznut!'),
    ('To be, or not to be, that is the question',
        'Vq dg, qt qrw vq dg, xlex ku wkh ycmabqwv')
]


@pytest.mark.parametrize('input, expected', data)
def test_caesar_cipher2(input, expected):
    actual = caesar_cipher2(input)
    assert actual == expected
