import sys

input = sys.stdin.readline

n = int(input())
dp = [0]*(n+1)

def fib(n):
    if n <= 1:
        return n
    elif dp[n] != 0:
        return dp[n]
    dp[n] = fib(n-1) + fib(n-2)
    return dp[n]
print(fib(n))