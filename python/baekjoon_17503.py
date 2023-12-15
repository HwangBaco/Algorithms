# N : 축제가 열리는 기간 == 마실 맥주 수
# M : 채워야 하는 선호도의 합
# K : 마실 수 있는 맥주 종류 == for loop range
# v : 선호도 v
# c : 도수 c
"""
from collections import defaultdict as dd

n, m, k = map(int, input().split())
d = dd(int)
for _ in range(k):
    v, c = map(int, input().split())
    d[v] = c
"""

