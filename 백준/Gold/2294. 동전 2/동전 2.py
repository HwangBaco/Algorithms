import sys
input = sys.stdin.readline

N, K = map(int, input().split())
dp = [10**18] * (K+1)
dp[0] = 0

for _ in range(1,N+1):
    v = int(input())
    for i in range(v, K+1):
        dp[i] = min(dp[i], dp[i-v]+1)
if dp[K] == 10**18:
    print(-1)
else:
    print(dp[K])