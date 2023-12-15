# 수 뒤집기
t = int(input())
for _ in range(t):
    n = input()
    temp = str(int(n) + int(n[::-1]))
    is_index_error = False
    for i in range(len(temp)//2):
        if temp[i] == temp[-i-1]:
            is_index_error = True
        else:
            is_index_error = False
            break
    if is_index_error: print("YES")
    else: print("NO")