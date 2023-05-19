import sys
input = sys.stdin.readline

n, m = map(int, input().split())
li = list(map(int, input().split()))

left, right = 0, 1
sum = li[left]
mx = 0
while True:
    if right >= n: break

    if right < n:
        if sum+li[right] <= m:
            sum += li[right]
            mx = max(mx, sum)
            right += 1
        elif sum+li[right] > m:
            sum -= li[left]
            left += 1
print(mx)