N, K = map(int, input().split())
s = input()
li = list(map(int, s.split(',')))

for i in range(K):
    for j in range(len(li) - 1):
        li[j] = li[j+1] - li[j]
    li.pop()
print(','.join(map(str, li)))
