def has_digit(password):
    return len([ch for ch in password if ch.isdigit()]) > 0


def has_upper(password):
    return len([ch for ch in password if ch.isupper()]) > 0


def has_lower(password):
    return len([ch for ch in password if ch.islower()]) > 0


def has_big_length(password):
    return len(password) >= 8


def is_good_password(password):
    return has_digit(password) and has_upper(password) and \
        has_lower(password) and has_big_length(password)
