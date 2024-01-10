from datetime import datetime
from calendar import monthrange


def get_month_length(month):
    current_year = datetime.now().year
    return monthrange(current_year, month)[1]
