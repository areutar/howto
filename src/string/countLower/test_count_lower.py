from count_lower import *
import pytest


@pytest.mark.parametrize('input, expected', [
    ('abcABCD12345', 3),
    ('gggggggg1212321ABDCEFCE', 8),
    ('2376423745dhdhdPPPP', 5),
    ('1v2b3n4m5k6h7GDFGDFd', 7)
])
def test_count_lower(input, expected):
    assert count_lower(input) == expected
