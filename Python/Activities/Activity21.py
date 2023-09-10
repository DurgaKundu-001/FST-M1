import pytest


def test_sum_two():
    a = 8
    b = 9
    sum = 0
    sum = a + b
    assert sum == 17



def test_diff_two():
    x = 19
    y = 9
    diff = 0
    diff = x - y
    assert diff == 10



def test_product_two():
    p = 9
    q = 5
    prod = p * q
    assert prod == 45



def test_quotient_two():
    m = 88
    n = 11
    assert m / n == 8
