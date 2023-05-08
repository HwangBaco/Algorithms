# 2*N 직사각형을 1*2, 2*1 타일로 채우는 방법의 수

# 문제 해석
# 경우의 수를 분석할 때, 매 단계마다 변동이 발생할 수 있으므로 DP로 누적하여 계산하는 것이 맞음
# ---
# n-2 길이의 블록이 쌓여있다고 할 때,
# 가로블록을 놓는 경우, 세로블록을 놓는 경우
# n-1 길이의 블록이 쌓여있다고 할 때,
# 세로블록을 놓는 경우

import sys
input = sys.stdin.readline
sys.setrecursionlimit(10000)
def dp(n):
    global dp_arr
    if n == 0: return 1
    if n == 1: return 1
    if n == 2: return 2
    if dp_arr[n] != 0:
        return dp_arr[n]
    else:
        dp_arr[n] += dp(n-1) + dp(n-2)
        return dp_arr[n]


n = int(input())
dp_arr = [0] * (n+1)
print(dp(n)%10007)
