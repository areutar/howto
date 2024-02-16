from move_robot import *
import pytest


@pytest.mark.parametrize('input, expected', [

])
def test_move_robot(input, expected, capsys):
    move_robot(input)
    captured = capsys.readouterr().out.strip()
    assert captured == expected
