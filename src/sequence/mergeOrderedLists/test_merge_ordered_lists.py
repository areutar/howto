from merge_ordered_lists import *
import pytest

data = [
    ([1, 2, 3], [5, 6, 7, 8], [1, 2, 3, 5, 6, 7, 8]),
    ([1, 7, 10, 16], [5, 6, 13, 20], [1, 5, 6, 7, 10, 13, 16, 20]),
    ([1], [2], [1, 2]),
    ([1, 2], [1, 3], [1, 1, 2, 3]),
    ([10, 11, 12], [1, 2,  3], [1, 2, 3, 10, 11, 12]),
]


@pytest.mark.parametrize('list1, list2, expectedList', data)
def test_merge_ordered_lists1(list1, list2, expectedList):
    assert merge_ordered_lists1(list1, list2) == expectedList


@pytest.mark.parametrize('list1, list2, expectedList', data)
def test_merge_ordered_lists2(list1, list2, expectedList):
    assert merge_ordered_lists2(list1, list2) == expectedList
