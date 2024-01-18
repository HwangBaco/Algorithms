N, M = map(int, input().split())
S, L = set(), list()
result = 0

for _ in range(N):
    str = input()
    S.add(str)
for _ in range(M):
    str = input()
    L.append(str)

for elem in S:
    cnt = L.count(elem)
    result += cnt
print(result)