s1 = input()
s2 = input()
arr = [[0]*len(s2) for _ in range(len(s1))]
print(arr)
idx, jdx = 0,0
for i in s1:
    temp = 0
    idx += 1
    for j in s2:
        jdx += 1
        if j == i:
            temp += 1
        arr[idx][jdx] = temp
print(arr)