import sys
input = sys.stdin.readline
sys.setrecursionlimit(10000)

def dp(n):
    global li
    li[0] = 1
    li[1] = 1
    li[2] = 3
    if li[n] != 0:
        return li[n]
    for i in range(3,n+1):
        li[i] = li[i-1] + 2*li[i-2]
    # li[n] = dp(n - 1) + 2*dp(n - 2)
    return li[n]

li = [0] * 251
while True:
    try:
        n = int(input())
        print(dp(n))
    except EOFError:
        break