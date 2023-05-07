# N개의 수가 주어지고 : 1 <= N <= 1,000,000
# N개의 수 각 항을 자기보다 작은 수의 개수로 변환

from collections import defaultdict as dd
import sys
input = sys.stdin.readline

t = int(input())
d = dd(int)
li = list(map(int,input().split()))
order = -1
acc = 0
_li = li.copy()
_li.sort(key=lambda x : x)
for i in range(t):
    if i > 0 and _li[i] == _li[i-1]:
        d[_li[i]] = order
    else:
        order += 1
        d[_li[i]] = order
for i in li:
    print(d[i], end=' ')
