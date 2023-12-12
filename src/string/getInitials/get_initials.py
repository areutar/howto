def get_initials(str):
  first_letters = [word[0] for word in str.split()]
  return '.'.join(first_letters) + '.'