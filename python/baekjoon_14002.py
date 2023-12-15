n = int(input())
s = list(map(int, input().split()))

dp = [1 for i in range(n)]

for i in range(n):
    for j in range(i):
        if s[i] > s[j]:
            dp[i] = max(dp[i], dp[j] + 1)
length = max(dp)
print(length)
ans = list()
for i in range(n-1, -1, -1):
    if dp[i] == length:
        ans.append(s[i])
        length -= 1

print(' '.join(map(str, ans[::-1])))
