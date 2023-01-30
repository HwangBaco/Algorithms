n = int(input())
res = [[],[],[]]
for i in range(n):
    a, b, c = map(int,input().split())
    res[0].append(a)
    res[1].append(b)
    res[2].append(c)

ans = [[]*i for i in range(n)]
for i in range(n):
    for j in range(3):
        if res[j].count(res[j][i]) == 1:
            ans[i].append(res[j][i])
        else:
            ans[i].append(0)
    print(sum(ans[i]))