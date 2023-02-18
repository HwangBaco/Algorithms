A, I = map(int, input().split())
x = A * (I-0.99999999999999999999)
print(x.__ceil__())