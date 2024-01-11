from is_correct_brackets import *
import pytest


@pytest.mark.parametrize('input, expected', [
    ('((()))', 'True'),
    ('(()())', 'True'),
    ('(())()', 'True'),
    ('()(())', 'True'),
    ('()()()', 'True'),
    ('()(())()()()(())()(()())((()))', 'True'),
    ('()(())()(()())((()))()(())', 'True'),
    ('())()()()(', 'False'),
    (')))(((', 'False'),
    ('()(())()((())((()))()(())', 'False'),
    ('()(())()(()())((()))()(()', 'False'),
    (')(())()(()())((()))()(())', 'False'),
    ('())(()', 'False'),
    (')))', 'False'),
    ('((((', 'False'),
    ('())((((())))', 'False')
])
def test_is_correct_brackets(input, expected, capsys):
    is_correct_brackets(input)
    captured = capsys.readouterr().out.strip()
    assert captured == expected
