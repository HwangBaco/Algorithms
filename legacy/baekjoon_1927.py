from heapq import heappush, heappop
hq = []
for _ in range(int(input())):
    n = int(input())
    if n == 0:
        if hq:
            print(heappop(hq))
        else:
            print(0)
    else:
        heappush(hq, n)
