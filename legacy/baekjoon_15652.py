### 순열조합 로직
# from itertools import combinations_with_replacement as cbwr
# n, m = map(int, input().split())
# arr = [i for i in range(1, n+1)]
# for x in cbwr(arr, m):
#     print(' '.join(map(str, x)))

### 재귀함수 로직
def go(arr, start):
    if len(arr) == m:
        print(' '.join(map(str, arr)))
        return
    for i in range(start, n+1):
        go(arr + [i], i)

n, m = map(int, input().split())
go([], 1)