Exam_tuples = input("Please enter a of number separated by comma ")
list2 = Exam_tuples.split(",")

print("Elements that are divisible by 5 are as below: ")
for x in list2:
    if int(x) % 5 == 0:
        print(x)
