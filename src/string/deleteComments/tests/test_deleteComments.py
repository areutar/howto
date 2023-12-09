# from __future__ import absolute_import
from src.string.deleteComments.delete_comments import *
import pytest


data = [
    (['''privet(@*)(!$&(%(@)%                           #  wewjf wfmweo qikfwif'''],
     'privet(@*)(!$&(%(@)%'),
    (['print("Введите своё имя")',
      'name = input()',
      'print("Введите пароль, если имеется")    # ахахахах вам не поймать меня',
      'password = input()',
      'if password == "hoover":',
      'print("Здравствуйте, рыцарь", name)         #долой Макнамару',
      'elif password == "noncr":',
      'print("Здравствуйте, паладин", name)',
      'elif password == "gelios":',
      'print("Здравствуйте, старейшина", name)          #Элайджа вперёд',
      'else:',
      'print("Здравствуйте, послушник", name)'
      ],
     ('print("Введите своё имя")\n'
      'name = input()\n'
      'print("Введите пароль, если имеется")\n'
      'password = input()\n'
      'if password == "hoover":\n'
      'print("Здравствуйте, рыцарь", name)\n'
      'elif password == "noncr":\n'
      'print("Здравствуйте, паладин", name)\n'
      'elif password == "gelios":\n'
      'print("Здравствуйте, старейшина", name)\n'
      'else:\n'
      'print("Здравствуйте, послушник", name)')
     ),
    (
        [
            'sampleefnwofewjiefw',
            'wjiefweofiwefinofewnniofweniobiewfibuewf',
            'wiognweifninoewf wefionw oifn oewniffeoiwn wniewfonifewnio',
            'fewkfnweo oiwefnwfiwni oinwefinniwfineiwno',
            'kkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkk'
        ],
        """sampleefnwofewjiefw
wjiefweofiwefinofewnniofweniobiewfibuewf
wiognweifninoewf wefionw oifn oewniffeoiwn wniewfonifewnio
fewkfnweo oiwefnwfiwni oinwefinniwfineiwno
kkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkk"""
    ),
    (
        ['111', '222'],
        '''111\n222'''
    ),
    (
        [
            'kdeaefk                           #tndjwd',
            'awk()()!!!                    #ttttt',
            'fowk',
            'ttttttttt',
            'pewrjwermwk #jelwee',
            'kekekekekekekekekekeke'
        ],
        """kdeaefk
awk()()!!!
fowk
ttttttttt
pewrjwermwk
kekekekekekekekekekeke"""
    )
]


@pytest.mark.parametrize('text_list, expected', data)
def test_delete_comments(text_list, expected):
    assert delete_comments(text_list) == expected
