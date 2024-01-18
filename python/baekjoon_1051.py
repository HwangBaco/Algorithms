n, m = map(int, input().split())
# n 또는 m 중 작은 수 x 기준으로 for i in range(x, 1, -1): 한 뒤에
# 문자열 탐색하면서 그 if s[i][j] == s[i][j+x]:면, s[i+x][j] == s[i+x][j+x] 인지도 확인
# 맞으면 x * x 출력
li = list()
ans = list()
for _ in range(n):
    s = input()
    li.append(s)

if n >= m:
    for d in range(m, 0, -1):
        for i in range(n):
            for j in range(m):
                try:
                    if li[i][j] == li[i][j + d] == li[i + d][j] == li[i + d][j + d]:
                        ans.append((d+1)*(d+1))
                except IndexError:
                    pass
    if len(ans) == 0: print(1)
    else: print(max(ans))
else:
    for d in range(n, 0, -1):
        for i in range(n):
            for j in range(m):
                try:
                    if li[i][j] == li[i][j + d] == li[i + d][j] == li[i + d][j + d]:
                        ans.append((d+1)*(d+1))
                except IndexError:
                    pass
    if len(ans) == 0: print(1)
    else: print(max(ans))