import sys
input = sys.stdin.readline

N, K, = map(int, input().split())
dp = [0] * (K+1)
dp[0] = 1
for _ in range(N):
    v = int(input())
    for i in range(v,K+1):
        dp[i] += dp[i-v]
print(dp[K])