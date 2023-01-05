num1 = input()
mark = input()
num2 = input()

if (mark == "*") :
    result = int(num1) * int(num2)
    print(result)
elif (mark == "+"):
    result = int(num1) + int(num2)
    print(result)
else :
    print("잘못된 입력입니다.")
