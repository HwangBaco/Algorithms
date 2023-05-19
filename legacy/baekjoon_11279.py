# 백준 11279. 최대 힙

from heapq import *
import sys
input = sys.stdin.readline

t = int(input())
hq = []
for _ in range(t):
    temp = int(input())
    if temp == 0:
        if hq:
            print(-heappop(hq))
        else:
            print(0)
    else:
        heappush(hq, -temp)
