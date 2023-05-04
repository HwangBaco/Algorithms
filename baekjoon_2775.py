# 0층 1호 : 1명 , ... , i호 : i명

# 1층 1호 : 1명 , 2호 : 1+2 , 3호 : 1+2+3 , 4호 : 1+2+3+4

# 2층 1호 : 1명 , 2호 1+3 , 3호 1+3+6

# k층 n호 : sum of dp[k-1][i] for i in range(1, n+1)

# 0층 : dp[0][i] for i in range(1, n+1)

# 1층 : dp[1][i] = sum of dp[0][i] for i in range(1, n+1)
import sys
input = sys.stdin.readline

def go(k,n, dp):
    if dp[k][n]: return dp[k][n]
    for i in range(1,n+1):
        dp[k][n] += go(k-1,i,dp)
    return dp[k][n]

# .text
t = int(input())
for i in range(t):
    k = int(input())
    n = int(input())
    dp = [[] for i in range(k+1)]
    dp[0] = [i for i in range(n+1)] # 0층 사람들 init
    for i in range(1,k+1):
        dp[i] = [0 for j in range(n+1)]
    ans = go(k,n,dp)
    print(ans)