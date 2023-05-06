# 국회의원 후보 N명 (1 <= N <= 50)
# 마을주민 M명 (1 <= M <= 100)

# 다른 후보의 득표수보다 많기만 하면 됨

# 다솜이가 매수해야 하는 사람의 최솟값을 출력하는 프로그램을 작성하라.

import sys
input = sys.stdin.readline
from heapq import *

# 기본 변수 및 입력 구성
stack = list()
ans = 0
flag = 0
N = int(input())

# 기호 1번을 찍으려고 하는 사람의 수 (입력)
# 기호 2번을 찍으려고 하는 사람의 수 (입력)
# ... N개의 줄에 걸쳐 입력
for i in range(N):
    stack.append(int(input()))

