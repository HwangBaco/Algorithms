# 국회의원 후보 N명 (1 <= N <= 50)
# 마을주민 M명 (1 <= M <= 100)

# 다른 후보의 득표수보다 많기만 하면 됨

# 다솜이가 매수해야 하는 사람의 최솟값을 출력하는 프로그램을 작성하라.

import sys
input = sys.stdin.readline
from heapq import *

# 기본 변수 및 입력 구성
ans = 0
hq = []
N = int(input())

# 기호 1번을 찍으려고 하는 사람의 수 (입력)
# 기호 2번을 찍으려고 하는 사람의 수 (입력)
# ... N개의 줄에 걸쳐 입력
dasom = int(input())
for i in range(1, N):
    heappush(hq, -(int(input())))

# hq가 비어있지 않으면,
# 아래 과정 반복
# 힙에서 하나 빼고(tmp) dasom이랑 비교
# dasom이 더 크면 break
# dasom이 더 작으면 ans += 1; tmp -= 1; dasom += 1; heappush(hq, -tmp);
if hq:
    while True:
        tmp = -heappop(hq)
        if dasom > tmp: break
        tmp -= 1
        dasom += 1
        heappush(hq, -tmp)
        ans += 1
    print(ans)

# hq가 비어있으면 print(0)
else:
    print(ans)

