from number_of_articles import get_number_of_articles

import pytest

data = [
    ('A An The', 3),

    ('''a a a a a A and An an ana ana aba ab ab 
     The the a a theh the opathe''', 13),

    ("""William Shakespeare was born in the town 
of Stratford, England, in the year 1564. When 
he was a young man, Shakespeare moved to the 
city of London, where he began writing plays. 
His plays were soon very successful, and were 
enjoyed both by the common people of London 
and also by the rich and famous. In addition 
to his plays, Shakespeare wrote many short poems 
and a few longer poems. Like his plays, these 
poems are still famous today.""", 7),

    ("""There have been many great writers in the
history of English literature, but there is
no doubt about which writer was the greatest.
Many people consider William Shakespeare to
have been the best writer who ever lived.""", 3),

    ("""Shakespeare’s most famous plays include Romeo  
and Juliet, Macbeth, Hamlet, King Lear, Othello,  
and Julius Caesar. Usually, Shakespeare did  
not invent the stories that he told in his plays.  
Instead, he wrote his plays using stories that  
already existed. However, Shakespeare’s plays  
told these stories in a more interesting way  
than ever before. Some of the stories were tragedies,  
some were comedies, and some described historical  
events.""", 3)
]


@pytest.mark.parametrize('input, expected', data)
def test_number_of_articles(input, expected):
    assert expected == get_number_of_articles(input)
