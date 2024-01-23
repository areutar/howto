def four_fifths_problem(threshold):
    degrees5 = [i ** 5 for i in range(threshold)]
    result = []
    for i in range(1, threshold):
        for j in range(i, threshold):
            for k in range(j, threshold):
                for l in range(k, threshold):
                    root = (degrees5[i] + degrees5[j] + degrees5[k]
                            + degrees5[l]) ** (1/5)                    
                    if (root - int(root)) < 0.0000000000001:
                        result.append([i, j, k, l, int(root)])
    return result
