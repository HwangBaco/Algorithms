def go(arr, ans, start):
    if len(ans) == m:
        print(' '.join(map(str, ans)))
        return
    for i in range(start, n):
        # print(type(arr), type(ans))
        go(arr, ans+[arr[i]], i)

n, m = map(int, input().split())
arr = sorted(list(map(int, input().split())))
go(arr, [], 0)