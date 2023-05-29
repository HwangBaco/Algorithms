"""백준 1927"""

from heapq import heappush, heappop
hq = []
for _ in range(int(input())):
    n = int(input())
    if n:
        heappush(hq, n)
    else:
        if len(hq):
            print(heappop(hq))
        else:
            print(0)