from making_slices import *
import pytest


@pytest.mark.parametrize('input, expected', [
    ('abcdefghijklmnopqrstuvwxyz',
     """c
y
abcde
abcdefghijklmnopqrstuvwx
acegikmoqsuwy
bdfhjlnprtvxz
zyxwvutsrqponmlkjihgfedcba
zxvtrpnljhfdb"""),
    ('The weak can never forgive. '
     'Forgiveness is the attribute of the strong',
        """e
n
The w
The weak can never forgive. Forgiveness is the attribute of the stro
Tewa a ee ogv.Frieesi h trbt ftesrn
h ekcnnvrfrie ogvns steatiueo h tog
gnorts eht fo etubirtta eht si ssenevigroF .evigrof reven nac kaew ehT
got h oeuitaets snvgo eirfrvnncke h"""
     ),
    ('There is no such thing as an accident. '
     'What we call by that name is the effect of some cause '
     'which we do not see',
     """e
e
There
There is no such thing as an accident. What we call by that name is the effect of some cause which we do not s
Teei osc hn sa ciet htw alb htnm steefc fsm as hc ed o e
hr sn uhtiga nacdn.Wa ecl yta aei h feto oecuewihw ontse
ees ton od ew hcihw esuac emos fo tceffe eht si eman taht yb llac ew tahW .tnedicca na sa gniht hcus on si erehT
estno whiweuceo otef h iea aty lce aW.ndcan agithu ns rh"""
     ),
    ('Success is the ability to go from failure to failure'
     ' without losing your enthusiasm',
     """c
s
Succe
Success is the ability to go from failure to failure without losing your enthusia
Scesi h blt og rmfiuet alr ihu oigyu nhsam
ucs steaiiyt ofo alr ofiuewtotlsn oretuis
msaisuhtne ruoy gnisol tuohtiw eruliaf ot eruliaf morf og ot ytiliba eht si sseccuS
mashn uygio uhi rla teuifmr go tlb h isecS"""
     )
])
def test_making_slices(input, expected, capsys):
    making_slices(input)
    captured = capsys.readouterr().out.strip()
    assert captured == expected
