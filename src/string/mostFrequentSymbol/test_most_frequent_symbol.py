from most_frequent_symbol import *
import pytest

data = [
    ('aaaabbc', 'a'),
    ('abaabbcccc', 'c'),
    ('pppppppppppppppppppppuuuuuuuuuuuuuuuuuuuuuuqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqq', 'q'),
    ('asasasasasppppppppppppppppppppppppppqw', 'p'),
    ('aaaAAAA', 'A'),
    ('привет питонннннннннннннннНННН', 'н'),
    ('11111111111111111111111111111111111111', '1'),
    ("""jfnmdbsdfnsjfqenfdssjdfhsdjlkppppppppppppppppppggggg
 xxzzzssswwwwwwwwwwwwwwwwwwfgdfxdfg""", 'w')
]


@pytest.mark.parametrize('input, expected', data)
def test_most_frequent_symbol(input, expected):
    assert expected == most_frequent_symbol(input)
