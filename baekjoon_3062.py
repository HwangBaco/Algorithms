# 수 뒤집기
t = int(input())
for _ in range(t):
    n = input()
    temp = str(int(n) + int(n[::-1]))
    flag = False
    for i in range(len(temp)//2):
        if temp[i] == temp[-i-1]:
            flag = True
        else:
            flag = False
            break
    if flag: print("YES")
    else: print("NO")