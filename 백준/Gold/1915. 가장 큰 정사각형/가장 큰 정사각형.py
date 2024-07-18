N, M = map(int, input().split())
dp = [[int(i) for i in input()] for _ in range(N)]
for i in range(1,N):
    for j in range(1,M):
        if dp[i][j] >= 1:
            dp[i][j] = min(dp[i-1][j], dp[i][j-1], dp[i-1][j-1]) + 1
ans = 0
for i in range(N):
    for j in range(M):
        ans = max(ans, dp[i][j])
print(ans*ans)