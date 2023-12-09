def delete_comments(text_list):
    comment_sign = '#'
    result = []
    for line in text_list:
        if comment_sign in line:
            index_comment = line.index(comment_sign)
            line = line[:index_comment]
        result.append(line.rstrip())
    return '\n'.join(result)
