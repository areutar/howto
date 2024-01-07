def star_triangle2(input):
    height = int(input) // 2 + 1
    for i in range(-height + 1, height):
        print('*' * (height - abs(i)))