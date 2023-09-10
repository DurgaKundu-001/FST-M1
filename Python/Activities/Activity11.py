fruit_shop = {
    "apple":100,
    "Orange":120,
    "Banana":50,
    "Grapes":80
}

item=input("Please enter which fruit you want to check ").lower()
if item in fruit_shop:
    print("This item is available")
else:
    print("This item is unavailable")
