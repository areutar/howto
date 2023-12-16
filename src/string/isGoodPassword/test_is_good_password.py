from is_good_password import *
import pytest


@pytest.mark.parametrize('password, expected', [
    ('aaAA12qqp', True),
    ('AAPPqq9S', True),
    ('99yyPPgg', True),
    ('aaaaaaaaaaaaa', False),
    ('AAAAAAAAAAA', False),
    ('734638763978653', False),
    ('AABBccssss', False),
    ('AA23423423', False),
    ('dsas233232232', False),
    ('99yyPPg', False),
    ('()+_№;%:', False),
    ('aaaaaaA@', False),
])
def test_is_good_password(password, expected):
    assert is_good_password(password) == expected
