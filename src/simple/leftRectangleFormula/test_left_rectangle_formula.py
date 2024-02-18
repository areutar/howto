from left_rectangle_formula import *
import pytest


@pytest.mark.parametrize('input, expected', [

])
def test_left_rectangle_formula(input, expected, capsys):
   left_rectangle_formula(input)
   captured = capsys.readouterr().out.strip()
   assert captured == expected