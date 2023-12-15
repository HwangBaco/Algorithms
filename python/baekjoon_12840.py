import sys
input = sys.stdin.readline

h, m, s = map(int, input().split())
total_sec = h*3600 + m*60 + s
for _ in range(int(input())):
    li = list(map(int, input().split()))
    if li[0] == 1: # 시계를 앞으로 li[1]초 돌린다.
        total_sec += li[1]
    elif li[0] == 2: # 시계를 뒤로 li[1]초 돌린다.
        if total_sec - li[1] >= 0: total_sec -= li[1]
        else: total_sec = total_sec - li[1] + (3600*24)
    else: # 시계 상황 출력
        h = (total_sec // 3600) % 24
        m = (total_sec % 3600) // 60
        s = (total_sec % 3600) % 60
        print(h, m, s)
