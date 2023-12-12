def find_all_occurrences(target, symbol):
  symbols = []
  index = 0
  while index >= 0:
    index = target.find(symbol, index)
    if index >= 0:
      symbols.append(index)
      index += 1
  return symbols