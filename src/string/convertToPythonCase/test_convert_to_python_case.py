from convert_to_python_case import *
import pytest


@pytest.mark.parametrize('input, expected', [
    ('ThisIsCamelCased', 'this_is_camel_cased'),
    ('IsPrimeNumber', 'is_prime_number'),
    ('ConvertToInt32', 'convert_to_int32'),
    ('MyMethodThatDoSomething', 'my_method_that_do_something'),
    ('IsHeFreeToGo', 'is_he_free_to_go'),
    ('FBIIsWatchingYou', 'f_b_i_is_watching_you')
])
def test_convert_to_python_case(input, expected, capsys):
    convert_to_python_case(input)
    captured = capsys.readouterr().out.strip()
    assert captured == expected
