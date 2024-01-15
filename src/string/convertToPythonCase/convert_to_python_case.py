def convert_to_python_case(input):
    snake_list = []
    for i in range(len(input)):
        if input[i].isupper():
            if i > 0:
                snake_list.append('_')
            snake_list.append(input[i].lower())
        else:
            snake_list.append(input[i])
    result = ''.join(snake_list)
    print(result) 