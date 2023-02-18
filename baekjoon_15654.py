def go(arr, ans):
    if len(ans) == m:
        print(' '.join(map(str, ans)))
        return
    for i in arr:
        if i not in ans:
            go(arr, ans+[i])
n, m = map(int, input().split())
arr = sorted(list(map(int, input().split())))
go(arr, [])