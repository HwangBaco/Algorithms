N, M = map(int, input().split())
arr = []
for _ in range(N):
    arr.append(int(input()))
arr.sort()
left = 0
right = 1
ans = 10**18
while left <= right < N:
    if arr[right] - arr[left] < M:
        right += 1
    else:
        ans = min(arr[right] - arr[left], ans)
        left += 1
print(ans)