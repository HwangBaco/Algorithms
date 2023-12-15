import sys
input = sys.stdin.readline

# """시간 초과 로직"""
# n, m = map(int, input().split())
# li = list(map(int, input().split()))
#
# for _ in range(m):
#     i, j = map(int, input().split())
#     print(sum(li[i-1:j]))

"""누적합 로직"""
n, m = map(int, input().split())
li = list(map(int, input().split()))
prefix_sum = [0] * (n+1)

# 누적합 배열 구하기
for i in range(1,n+1):
    prefix_sum[i] = li[i-1] + prefix_sum[i-1]

for _ in range(m):
    i, j = map(int, input().split())
    print(prefix_sum[j] - prefix_sum[i-1])