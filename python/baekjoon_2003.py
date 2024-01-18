n, m = map(int, input().split())
li = list(map(int, input().split()))
left, right = 0, 1
res = li[0]

ans = 0

while True:
    if res < m:
        if right < n:
            res += li[right]
            right += 1
        else:
            break
    elif res > m:
        res -= li[left]
        left += 1
    else:
        ans += 1
        res -= li[left]
        left += 1
print(ans)
