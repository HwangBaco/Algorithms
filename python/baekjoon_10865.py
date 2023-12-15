n, m = map(int, input().split())
li = [0 for _ in range(n)]
for _ in range(m):
    a, b = map(int, input().split())
    li[a-1] += 1
    li[b-1] += 1
print('\n'.join(map(str, li)))