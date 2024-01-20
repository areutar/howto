from is_pangram import *
import pytest


@pytest.mark.parametrize('input, expected', [
    ('abcdefghijklmnopqrstuvwxyz', 'True'),
    ('The quick brown fox jumps over the lazy dog', 'True'),
    ('Jackdaws love my big sphinx of quartz', 'True'),
    ('The five boxing wizards jump quickly. ', 'True'),
    ('ddddddddddddddddddddddddddddddddddddddddddddddddddddddd', 'False'),
    ('abcdefghijklmnopqastuvwxyzabcdefghijklmnopq', 'False'),
    ('def test_is_pangram(input, expected, capsys):', 'False'),
    ('''def test_is_pangram(input, expected, capsys):
    is_pangram(input)
    captured = capsys.readouterr().out.strip()
    assert captured == expected''', 'False')
])
def test_is_pangram(input, expected, capsys):
    is_pangram(input)
    captured = capsys.readouterr().out.strip()
    assert captured == expected
