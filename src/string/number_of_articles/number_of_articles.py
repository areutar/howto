def get_number_of_articles(string):
    text_list = string.lower().split()
    articles = ['a', 'an', 'the']
    count = len([word for word in text_list if word in articles])
    return count
