numbers = input()

list = numbers.split()

num1 = int(list[0])
num2 = int(list[1])
num3 = int(list[2])

if num1 < num2:
    if num1 < num3:
        list[0] = num1
        if num2 < num3:
            list[1] = num2
            list[2] = num3
        else:
            list[1] = num3
            list[2] = num2
    else:
        list[0] = num3
        list[1] = num1
        list[2] = num2
else:
    if num2 < num3:
        list[0] = num2
        if num1 < num3:
            list[1] = num1
            list[2] = num3
        else:
            list[1] = num3
            list[2] = num1
    else:
        list[0] = num3
        list[1] = num2
        list[2] = num1

# result
for num in list:
    print(num, end=" ")

