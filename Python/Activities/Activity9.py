list1=[2, 4, 3, 7, 6, 9]
list2=[1, 6, 8, 9, 4]
listOdd=[]
listEven=[]
for x in list1:
    if x%2 != 0:
        listOdd.append(x)
for y in list2:
    if y%2 == 0:
        listEven.append(y)
list3=listOdd + listEven
print(f"Here is the new list which contains only odd numbers from the first list and even numbers from the second list: {list3}")