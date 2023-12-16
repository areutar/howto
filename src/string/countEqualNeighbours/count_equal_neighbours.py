def count_equal_neighbours(input):
    return len([i for i in range(len(input) - 1)
            if input[i] == input[i + 1]])
