from check_phone_number import *
import pytest

data = [
    ('7-301-447-5820', True),
    ('301-447-5820', True),
    ('301-4477-5820', False),
    ('3X1-447-5820', False),
    ('3014475820', False),

    ('8-301-447-5820', False),
    ('77-301-447-5820', False),
    ('311-4A7-5820', False),
    ('311-487-582B', False),
    ('3A1-4M7-582B', False),

    ('7-3A1-447-5820', False),
    ('77-301-447-5820', False),
    ('7-301-4BB-5820', False),
    ('7-abc-abc-abc', False),
    ('abc-abc-abc', False),

    ('7-123-456-c-7890', False),
    ('7-1234-567-890', False),
    ('7-123-4567-890', False),
]


@pytest.mark.parametrize('input, expected', data)
def test_check_phone_number(input, expected):
    assert check_number(input) == expected
