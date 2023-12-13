from every_third import *
import pytest

data = [
('Python', 'yton'),
('Hello', 'elo'),
('qwer', 'we'),
('p', ''),
('ab', 'b'),
('abc', 'bc'),
('abcdefg', 'bcef'),
('abcdefghij', 'bcefhi'),
('abcdefghijkl', 'bcefhikl'),
('qwertyuiopasdfghjklzxcvbnm', 'wetyioasfgjkzxvbm'),
]


@pytest.mark.parametrize("input, expected", data)
def test_every_third(input, expected):
    assert expected == every_third(input)

@pytest.mark.parametrize("input, expected", data)
def test_every_third_with_del(input, expected):
    assert expected == every_third_with_del(input)
