from boh import boh
import pytest


@pytest.mark.parametrize('input, expected', [
    ('10', '1010\n12\nA\n'),
    ('128', '10000000\n200\n80\n'),
    ('150', '10010110\n226\n96\n'),
    ('18765', '100100101001101\n44515\n494D\n')
])
def test_boh(input, expected, capsys):
    boh(input)
    captured = capsys.readouterr().out
    assert captured == expected
