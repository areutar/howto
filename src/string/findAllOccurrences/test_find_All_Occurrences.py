from find_all_occurrences import find_all_occurrences
import pytest

data = [
  ('abcdabcaaa', 'a', [0, 4, 7, 8, 9]),
  ('abcadbcaaa', 'e', []),
  ('abcadbcaaa', 'd', [4]),
  ('tttt', 't', [0, 1, 2, 3]),
  ('ppooooopp', 'p', [0, 1, 7, 8]),
  ('ppooooopp', 'o', [2, 3, 4, 5, 6]),
  ('ppooppoopp', 'o', [2, 3, 6, 7]),
]

@pytest.mark.parametrize('text, ch, expected', data)
def test_arithm(text, ch, expected):
  assert find_all_occurrences(text, ch) == expected