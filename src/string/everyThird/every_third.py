def every_third_with_del(input):
  lst = list(input)
  del lst[::3]
  return ''.join(lst)

def every_third(input):
  return ''.join([input[i] for i in range(len(input)) if i % 3 != 0])

