from collections import deque
import sys
input = sys.stdin.readline

N = int(input())
queue = deque(map(int, input().split()))
res = list()
stack = list()
order = 1

while True:
    if order > N: break
    elif len(stack) > 0 and stack[-1] == order:
        tmp = stack.pop()
        res.append(tmp)
        order += 1
    elif len(queue) > 0 and queue[0] == order:
        this = queue.popleft()
        res.append(this)
        order += 1
    elif len(queue) > 0:
        this = queue.popleft()
        stack.append(this)
    else: break
ans = [i for i in range(1, N+1)]
if res == ans:
    print("Nice")
else:
    print("Sad")
