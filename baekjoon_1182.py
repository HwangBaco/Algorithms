from itertools import combinations as cb

n, s = map(int, input().split())
arr = list(map(int, input().split()))
cnt = 0

for i in range(1, n+1):
    for t in cb(arr, i):
        # print(t)
        # print(f"sum(t): {sum(t)}")
        if sum(t) == s: cnt += 1
print(cnt)