import sys
input = sys.stdin.readline

N = int(input())
# 임의로 숫자 하나를 정하고
# 그 앞에 몇개의 숫자가 있을지 계산해보는 것
# 6이라 하면
# N*N에서 N=3이니까
K = int(input()) - 1

def cal(t):
    res = 0
    for i in range(1, N+1):
        if t // i <= N:
            res += t // i
        else :
            res += N
    return res

def lower_bound():
    left = 1
    right = 10**18
    while left < right:
        mid = (left + right) // 2
        if cal(mid) > K:
            right = mid
        else:
            left = mid + 1
    return left
print(lower_bound())