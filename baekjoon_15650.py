### 순열조합 풀이
# from itertools import combinations as cb
#
# n, m = map(int, input().split())
# arr = [i for i in range(1, n+1)]
#
# for t in cb(arr, m):
#     print(' '.join(map(str, t)))

### 재귀함수 풀이
def go(check, start):
    if sum(check) == m:
        ans = [i for i in range(1,n+1) if check[i-1]]
        print(' '.join(map(str, ans)))
        return
    for i in range(start, n):
        if check[i] == 0:
            check[i] = 1
            go(check, i+1)
            check[i] = 0

n, m = map(int, input().split())
go([0] * n, 0)