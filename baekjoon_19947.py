import sys
from math import trunc

input = sys.stdin.readline

h, y = map(int, input().split())
ans = 0

if y >= 5:
    exp = y // 5
    y = y % 5
    for _ in range(exp):
        h = trunc(h * 1.35)
if y >= 3:
    exp = y // 3
    y = y % 3
    for _ in range(exp):
        h = trunc(h * 1.2)
if y >= 1:
    exp = y // 1
    for _ in range(exp):
        h = trunc(h * 1.05)
print(h)
