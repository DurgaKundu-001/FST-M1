list1 = input("Please enter a list no separated by comma ")
list2 = list1.split(",")
print(list2)
sum = 0
for x in list2:
    sum = sum + int(x)
print(f"The sum of all the elements in a list is :  {sum}")
