def function(x):
    x = str(x)
    return int(x[0]) * len(x)

n = input()
temp = n
while True:
    result = function(n)
    if temp == result:
        print("FA")
        break
    else:
        temp = result