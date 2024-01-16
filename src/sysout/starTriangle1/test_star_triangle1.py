from star_triangle1 import *
import pytest


@pytest.mark.parametrize('input, expected', [
    (1, """*
"""),
    (2, """ *
***
"""),
    (8, ('       *\n'
     '      ***\n'
         '     *****\n'
         '    *******\n'
         '   *********\n'
         '  ***********\n'
         ' *************\n'
         '***************\n')
     )
])
def test_star_triangle1(input, expected, capsys):
    star_triangle1(input)
    captured = capsys.readouterr().out
    assert captured == expected
