from is_correct_brackets2 import *
import pytest


@pytest.mark.parametrize('input, expected', [
    ('()', 'True'),
    ('[]', 'True'),
    ('{}', 'True'),

    ('([][]  ){}', 'True'),
    ('([][]  ){lst = [1, 2]}', 'True'),
    ('([()()()..])', 'True'),
    ('''def test_is_correct_brackets2(input, expected, capsys):
    is_correct_brackets2(input)
    captured = capsys.readouterr().out.strip()
    assert captured == expected''', 'True'),
    ('''Runnable r = new Runnable() {             
            public void run() 
            { 
                System.out.println("run"); 
            } 
        }; ''', 'True'),
    ('([{([{([{}])}])}])', 'True'),
    ('(){[]}[({})[([{}])]]{([{{}}])}', 'True'),

    ('(', 'False'),
    ('[', 'False'),
    ('{', 'False'),
    (')', 'False'),
    (']', 'False'),
    ('}', 'False'),

    (')(', 'False'),
    ('][', 'False'),
    ('}{', 'False'),

    ('(]', 'False'),
    ('(}', 'False'),
    ('[)', 'False'),
    ('[}', 'False'),
    ('{)', 'False'),
    ('{]', 'False'),

    ('([)]', 'False'),
    ('({)}', 'False'),
    ('[(])', 'False'),
    ('[{]}', 'False'),
    ('{(})', 'False'),
    ('{[}]', 'False'),
], ids=[
    'simple_sequence_round_brackets',
    'simple_sequence_square_brackets',
    'simple_sequence_curly_brackets',

    'function_with_two_list_args',
    'function_with_list_initialization',
    'this_parametrize_test',
    'this_testing_function',
    'anonymous_class',
    'many_brackets',
    'ascending_brackets',

    'wrong_count_round_opening',
    'wrong_count_square_opening',
    'wrong_count_curly_opening',
    'wrong_count_round_closing',
    'wrong_count_square_closing',
    'wrong_count_curly_closing',

    'wrong_order_two_round',
    'wrong_order_two_square',
    'wrong_order_two_curly',

    'different_brackets_round+square',
    'different_brackets_round+curly',
    'different_brackets_square+round',
    'different_brackets_square+curly',
    'different_brackets_curly+round',
    'different_brackets_curly+square',

    'wrong_order_round+square',
    'wrong_order_round+curly',
    'wrong_order_square+round',
    'wrong_order_square+curly',
    'wrong_order_curly+round',
    'wrong_order_curly+square',
])
def test_is_correct_brackets2(input, expected, capsys):
    is_correct_brackets2(input)
    captured = capsys.readouterr().out.strip()
    assert captured == expected
