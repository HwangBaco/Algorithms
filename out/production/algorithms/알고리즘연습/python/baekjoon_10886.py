standard = 0
for i in range(int(input())):
    num = int(input())
    if num == 1:
        standard += 1
    else:
        standard -= 1

print("Junhee is cute!" if standard > 0 else "Junhee is not cute!")
