from list_of_all_chars import *
import pytest

data = [
    (['abc', 'def', 'ghi'],
     ['a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i']),

    (['asdfgh', 'nvbfghtuge', 'djnsmdcnks', 'ncjsdkncsdjkcn', 'dscnmscsm',],
     ['a', 's', 'd', 'f', 'g', 'h', 'n', 'v', 'b', 'f', 'g', 'h', 't', 'u', 'g', 'e', 'd', 'j', 'n', 's', 'm', 'd', 'c', 'n', 'k', 's', 'n', 'c', 'j', 's', 'd', 'k', 'n', 'c', 's', 'd', 'j', 'k', 'c', 'n', 'd', 's', 'c', 'n', 'm', 's', 'c', 's', 'm']),

    (['poiuytrewq'],
     ['p', 'o', 'i', 'u', 'y', 't', 'r', 'e', 'w', 'q']),
    (['098765', '4321'],
     ['0', '9', '8', '7', '6', '5', '4', '3', '2', '1']),

]


@pytest.mark.parametrize("strings, expectedList", data)
def test_list_of_all_chars(strings, expectedList):
    assert list_of_all_chars(strings) == expectedList
