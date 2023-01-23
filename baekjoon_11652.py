import sys
input = sys.stdin.readline

t = int(input())
d = dict()
for _ in range(t):
    n = int(input())
    if n in d.keys(): d[n] += 1
    else: d[n] = 1
new_d = list(d.items())
new_d.sort(key=lambda x : (-x[1], x[0]))
print(new_d[0][0])