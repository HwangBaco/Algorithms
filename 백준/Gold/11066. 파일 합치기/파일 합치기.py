import sys

input = sys.stdin.readline

ans = ""

def solve():
    global ans
    K = int(input())
    li = [0] + list(map(int, input().split()))
    ps = [0] * (K+1)
    for i in range(1, K+1):
        ps[i] = ps[i-1] + li[i]

    dp = [[0] * (K+1) for _ in range(K+1)]
    for i in range(2, K+1):
        for j in range(1, K-i+2):
            dp[j][j+i-1] = min(dp[j][k] + dp[k+1][j+i-1] for k in range(j, j+i-1)) + ps[j+i-1] - ps[j-1]
    ans += str(dp[1][K]) + "\n"

for _ in range(int(input())):
    solve()
print(ans)