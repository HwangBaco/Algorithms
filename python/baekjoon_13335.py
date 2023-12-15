# 트럭 하나 올린다.
# if 무게 여유로우면 -> 트럭 한칸 옮기고 하나 더 올린다.
# elif 무게 여유 x -> 트럭 한칸 옮긴다.

# 다리: deque -> w만큼 0으로 채워서 초기화
# 무게 측정은 deque.sum()으로
# 남은 트럭: stack -> 만약 0이 되면 round 출력
from collections import deque


n, w, l = map(int, input().split())
trucks = deque(map(int, input().split()))
bridge = deque(0 for i in range(w))
round = 0

while True:
    # print("----------------", round, "-------------------")
    # print("trucks: ", trucks)
    if sum(bridge) == 0 and not len(trucks): break
    round += 1
    # print("bridge: ", bridge)
    # print("sum(bridge): ", sum(bridge))
    if len(trucks) > 0 and sum(bridge) + trucks[0] <= l:
        bridge.pop()
        bridge.appendleft(trucks.popleft())
        # print("bridge: ", bridge)
    else:
        bridge.pop()
        if len(trucks) > 0 and sum(bridge) + trucks[0] <= l:
            bridge.appendleft(trucks.popleft())
            # print("bridge: ", bridge)
        else:
            bridge.appendleft(0)
            # print("bridge: ", bridge)

print(round)