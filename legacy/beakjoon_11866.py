"""
문제 11866 (덱?)

요세푸스 문제 0

n, k 입력이 주어지면

기본적으로 li = [i for i in  range(1,n+1)] 인 리스트가 있고,
이 리스트가 원으로 이루어져 있는 방식

루프를 걸고
idx += k
idx = (idx % n)
ans.append(li.pop(idx))

print("<"+', '.join(map(str, ans))+">")
"""
import sys
input = sys.stdin.readline

n, k = map(int ,input().split())

li = [i for i in range(1,n+1)]
idx = 0
ans = list()
while li:
    n = len(li)
    idx = (idx + k - 1) % n
    ans.append(li.pop(idx))
print("<"+', '.join(map(str, ans))+">")
