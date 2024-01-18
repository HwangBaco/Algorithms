"""
백준 5430: AC (덱)

pseudo code

t = int(input())

for i in range(t):
    cmd = input()
    n = int(input())
    dq = deque((map(int, input().split())))
    print(operation(cmd, dq))

def operation(cmd, dq):
    if cmd.count("D") > len(dq):
        print("error")
    else:
        for i in cmd:
            if i == "R":
                dq.reverse()
            elif i == "D":
                dq.popleft()
    ans = "["+','.join(map(str, dq))+"]"
    return ans
"""
import sys
input = sys.stdin.readline

t = int(input())

for i in range(t):
    cmd = input()
    n = int(input())
    s = input()
