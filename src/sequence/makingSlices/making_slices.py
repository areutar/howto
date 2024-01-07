def making_slices(input):
    [print(input[a:b:c]) for a, b, c in (
        (2, 3, None), (-2, -1, None), (0, 5, None), (0, -2, None),
        (None, None, 2), (1, None, 2), (None, None, - 1), (-1, None, -2))]


st = 'abcdefghijklmnopqrstuvwxyz'
print(st[3::-2])
print(st[3:-2])
print(st[-2:3])
print(st[-2:3:-1])
print(st[2:2])
print(st[2:3:1])
print(st[- 1:])
print(st[::26])
print(st[1:1:])
print(st[None:None:None])
print(st[:1:-2])