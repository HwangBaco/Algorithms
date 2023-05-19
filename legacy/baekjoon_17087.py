import sys
input = sys.stdin.readline

n, s = map(int, input().split()) # 동생 n명과 숨바꼭질, 수빈이는 점 s에 있음
li = list(map(int, input().split())) # 동생들 위치
ans = list()
for i in li:
    ans.append(ans(i - s))

print(min(ans))