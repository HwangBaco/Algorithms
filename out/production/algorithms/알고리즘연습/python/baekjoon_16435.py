def go(arr, m, idx):
    if idx < n and m >= arr[idx]:
        m += 1
        idx += 1
        go(arr, m, idx)
    else:
        print(m)
n, m = map(int, input().split())
arr = sorted(list(map(int, input().split())))
go(arr, m, 0)