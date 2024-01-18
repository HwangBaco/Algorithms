for i in range(int(input())):
    num1, num2 = map(int, input().split())
    print(f"You get {num1//num2} piece(s) and your dad gets {num1%num2} piece(s).")