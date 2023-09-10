def sum(list):
    sum = 0
    for x in list:
        sum = sum + x
    return sum


List1 = [12, 18, 5, 15]
sum1 = sum(List1)
print("The sum of all the elements in a list is :  "+ str(sum1))
