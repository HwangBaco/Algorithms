num1, num2 = map(str, input().split())
print(num1[::-1] if int(num1[::-1]) > int(num2[::-1]) else num2[::-1])