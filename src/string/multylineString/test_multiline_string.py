from multiline_string import *


def test__text_with_single_triple_quotes():
    assert text == text_with_single_triple_quotes


def test__text_with_double_triple_quotes():
    assert text == text_with_double_triple_quotes


def test__text_with_parentheses():
    assert text == text_with_parentheses


def test__text_with_backslash():
    assert text == text_with_backslash


def test__text_with_join():
    assert text == text_with_join


def test__text_with_square_brackets():
    assert text == text_with_square_brackets[0]
