# high = 나무 리스트의 최댓값
# low = 0

# mid = int((high + low)/2) 를 설정하고 나무를 베어본다.
# 나무를 벤 나머지 값들을 저장(res)해서 target(M)이랑 비교

# if 일치하면 그 때의 mid 출력
# elif res > target : low = mid + 1
# elif res < target : high = mid - 1

import sys
input = sys.stdin.readline
from random import *

"""random test"""
# n = randint(1,1000000)
# m = randint(1, 2000000000)
# li = list()
# for i in range(n):
#     li.append(randrange(1000000000))
# print("n :", n)
# print("m :", m)
# print("li :", li)

""".input"""
n, m = map(int, input().split())
li = list(map(int, input().split()))

""".text"""

high = max(li)
low = 0
while low <= high:

    res = 0
    # mid = int((high + low)//2)
    mid = (high + low)//2
    for i in li:
        if (i - mid) >= 0:
            res += (i - mid)
        else:
            res += 0
    # if res == m:
    #     break

    print("b", high, low, mid, res, m)
    if res >= m:
        low = mid + 1
    else:
        high = mid - 1
    print("a", high, low, mid, res, m)
print(high)