from itertools import combinations as cb

n, m = map(int, input().split())
arr = list(map(int, input().split()))

ans = 0
for t in cb(arr, 3):
    if sum(t) <= m: ans = max(ans, sum(t))
print(ans)