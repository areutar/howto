from exchange_with_minimum_coins import *
import pytest

coins = [1, 5, 10, 25]


@pytest.mark.parametrize('input, expected', [
    (49, 7),
    (1, 1),
    (5, 1),
    (10, 1),
    (25, 1),
    (2111, 86),
    (4, 4),
    (100, 4),
    (499, 25),
    (9, 5)
])
def test_exchange_with_minimum_coins(input, expected, capsys):
    exchange_with_minimum_coins(coins, input)
    captured = int(capsys.readouterr().out.strip())
    assert captured == expected
