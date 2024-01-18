import sys
input = sys.stdin.readline

n, m = map(int, input().split())
sample = list()
system = list()
# sample case
for i in range(n):
    a, b = input().split()
    sample.append(int(a==b))

for j in range(m):
    c, d = input().split()
    system.append(int(c==d))

if 0 in sample:
    print("Wrong Answer")
elif 0 in system:
    print("Why Wrong!!!")
else:
    print("Accepted")