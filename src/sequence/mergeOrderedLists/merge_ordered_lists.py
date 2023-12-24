import bisect


def merge_ordered_lists1(list1, list2):   
    result = list1[:]
    for elem in list2:
        print(type(elem))
        bisect.insort_left(result, elem)
    return result


def merge_ordered_lists2(list1, list2):    
    result = []
    ind1, ind2 = 0, 0
    while ind1 < len(list1) and ind2 < len(list2):
        if list1[ind1] <= list2[ind2]:
            result.append(list1[ind1])
            ind1 += 1
        else:
            result.append(list2[ind2])
            ind2 += 1
    if ind1 == len(list1):
        result.extend(list2[ind2:])
    else:
        result.extend(list1[ind1:])
    return result
