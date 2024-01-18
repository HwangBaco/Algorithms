from itertools import permutations as pm

N = int(input())
arr = tuple(map(int, input().split()))
ans = pm(sorted(arr), N)

cnt = 0
idx = 0
for case in ans:
    cnt += 1
    if arr == case:
        idx = cnt
print(' '.join(map(str,ans[idx+1])) if idx != len(list(ans)) else "-1")
