

def test_sum(list_num):
    sum = 0
    for x in list_num:
        sum = sum + int(x)
    print(sum)
    assert sum == 55


