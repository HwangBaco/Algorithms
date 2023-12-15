"""
스택에 우선순위와 location을 튜플로 묶어서 같이 저장하는 기법을 이용하면 훨씬 직관적이다.
하지만 이를 딕셔너리로 구현하고, 포인터를 옮기는 방식으로 구현해도 똑같지 않나?

아니다. 스택과 튜플을 같이 이용하는 방식과 딕셔너리를 사용하는 방식은 그 목적이 다르다.
기본적으로 key-value 매핑은 딕셔너리를 이용해도 무방하지만, 해당 로직에서는 조건을 만족하는 요소를
주기적으로 제거해줘야 한다. 따라서 이 문제에서는 stack + tuple 방식을 더 선호하고자 한다.

물론 딕셔너리로 구현할 수도 있을테지만, 더 쉽게 이해할 수 있는 방식으로 구현하는 것을 우선하자.
esp, 여기선 popleft()를 활용해야 하니 스택이 아닌 덱을 적용하려고 한다.
"""
from collections import deque
import sys

input = sys.stdin.readline
def solution(priorities, location):
    answer = 0
    d = deque()
    for idx, val in enumerate(priorities):
        d.append((idx, val))

    while d:
        is_pass = False

        # 만약 뒤에 우선순위가 더 높은 요소가 존재할 경우 -> pass
        for i in d:
            if d[0][1] < i[1]: is_pass = True

        if is_pass:
            tmp = d.popleft()
            d.append(tmp)
        else:
            answer += 1
            tmp = d.popleft()
            if tmp[0] == location: return answer
