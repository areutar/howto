from star_triangle2 import *
import pytest


@pytest.mark.parametrize('input, expected', [
    ('3',
     '''*
**
*'''
     ),
    ('5',
     """*
**
***
**
*"""
     ),
     ('11',
      '''*
**
***
****
*****
******
*****
****
***
**
*'''
      )
])
def test_star_triangle2(input, expected, capsys):
    star_triangle2(input)
    captured = capsys.readouterr().out.strip()
    assert captured == expected
