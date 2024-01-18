import sys
input = sys.stdin.readline
sys.setrecursionlimit(10**6) # Recursion Error에 대한 솔루션

def go(arr, idx, cmp):
    global ans
    if idx >= len(arr):
        print(ans)
        return
    if arr[idx] > cmp:
        ans += 1
        cmp = arr[idx]
    go(arr, idx+1, cmp)

arr = list()
for _ in range(int(input())):
    arr.append(int(input()))
arr.reverse()
ans = 1
go(arr, 1, arr[0])
