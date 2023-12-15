import math
# sys 모듈을 이용하여 빠른 입력 받기
input = __import__('sys').stdin.readline

A, B, V = map(int, input().split())

## first try code
# while(distance < V):
#     if day > 0:
#         distance -= B
#     day += 1
#     distance += A # 낮에 움직인 만큼 거리 추가
# print(day)

# 한 번에 오르는 경우
if (A >= V):
    print(1)

# 두 번 이상으로 오르는 경우
# (A - B) * x + A >= V 여야 하고 x를 구해야 하니까
# print((V-A)/(A-B) + 1)
else:
    print(int(math.ceil((V-A)/(A-B)) + 1))

