from caesar_cipher import caesar_cipher_code
import pytest


@pytest.mark.parametrize('shift, text, expected', [
    (10, 'Блажен, кто верует, тепло ему на свете!',
     'Лхкрпч, фьш мпъэпь, ьпщхш пцэ чк ымпьп!'),
    (17, 'To be, or not to be, that is the question!',
     'Kf sv, fi efk kf sv, kyrk zj kyv hlvjkzfe!'),
    (-7, 'Шсъцхр щмчжмщ йшм, нмтзж йшм лхшщзщг.',
     'Скупой теряет все, желая все достать.'),
    (-25, 'Sgd fqzrr hr zkvzxr fqddmdq nm sgd nsgdq rhcd ne sgd edmbd.',
     'The grass is always greener on the other side of the fence.'),
    (2, 'AbcАбвxyzэюя', 'CdeВгдzabяаб')
])
def test_caesar_cipher_code(shift, text, expected):
    actual = caesar_cipher_code(shift, text)
    assert actual == expected
