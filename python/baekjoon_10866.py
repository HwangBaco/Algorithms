import sys
input = sys.stdin.readline
from collections import deque

dq = deque()

# push_front X: 정수 X를 덱의 앞에 넣는다.
# push_back X: 정수 X를 덱의 뒤에 넣는다.
# pop_front: 덱의 가장 앞에 있는 수를 빼고, 그 수를 출력한다. 만약, 덱에 들어있는 정수가 없는 경우에는 -1을 출력한다.
# pop_back: 덱의 가장 뒤에 있는 수를 빼고, 그 수를 출력한다. 만약, 덱에 들어있는 정수가 없는 경우에는 -1을 출력한다.
# size: 덱에 들어있는 정수의 개수를 출력한다.
# empty: 덱이 비어있으면 1을, 아니면 0을 출력한다.
# front: 덱의 가장 앞에 있는 정수를 출력한다. 만약 덱에 들어있는 정수가 없는 경우에는 -1을 출력한다.
# back: 덱의 가장 뒤에 있는 정수를 출력한다. 만약 덱에 들어있는 정수가 없는 경우에는 -1을 출력한다.

for i in range(int(input())):
    s = list(map(str,input().split()))
    if len(s) == 2:
        if s[0] == "push_front":
            dq.appendleft(s[1])
        elif s[0] == "push_back":
            dq.append(s[1])
    else:
        if s[0] == "pop_front":
            if len(dq) > 0:
                x = dq.popleft()
                print(x)
            else:
                print(-1)

        elif s[0] == "pop_back":
            if len(dq) > 0:
                x = dq.pop()
                print(x)
            else:
                print(-1)
        elif s[0] == "size":
            print(len(dq))
        elif s[0] == "empty":
            if len(dq) == 0: print(1)
            else: print(0)
        elif s[0] == "front":
            if len(dq) > 0:
                print(dq[0])
            else:
                print(-1)
        elif s[0] == "back":
            if len(dq) > 0:
                print(dq[-1])
            else:
                print(-1)