from datetime import datetime
import locale


def get_local_name_of_month(lang, number):
    locale.setlocale(locale.LC_ALL, lang)
    date = datetime.now().replace(month=number)
    month = date.strftime('%B').lower()
    print(month)
