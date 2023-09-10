list=input("Enter the no of the list by comma separated value : ").split(",")
if(list[0]==list[-1]):
    Result = True
else:
    Result = False
print(f"Is first and last number of a list is same: {Result}")


