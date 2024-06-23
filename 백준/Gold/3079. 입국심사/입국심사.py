import sys
input = sys.stdin.readline

N, M = map(int, input().split())
time = []
for i in range(N):
    time.append(int(input()))

# 단순한 풀이 :
# 1. while (True): 로 초를 세면서 모든 배열의 숫자를 --하면서 세줌 (0이 되면 M-- 하고 consult[i] = time[i])
# -> 위 로직은 최악의 경우 O(M*T)라서 무조건 시간초과
# 2. 초를 파라메트릭 서치로 찍고, 각각 상담의 배수를 찍어서 M이 되는지 체크
# -> 이렇게 하면 O(logT)로 수행 가능

def cal(mid):
    res = 0
    for i in time:
        res += mid // i
    return res

left = 0
right = 10**18
ans = 10**18
while left < right:
    mid = (left + right) // 2
    if M <= cal(mid):
        right = mid
    else:
        left = mid + 1
print(right)