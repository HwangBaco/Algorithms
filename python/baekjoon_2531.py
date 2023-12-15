# 회전초밥 -> 나머지 연산으로 구현하는 아이디어
# 선택된 초밥을 딕셔너리로 구현
from collections import defaultdict as dd
import sys
input = sys.stdin.readline

n, d, k, c = map(int, input().split()) # 벨트 길이, 초밥 종류, 연속으로 먹는 갯수, 쿠폰 초밥
li = [int(input()) for _ in range(n)]

left, right = 0, k-1
ate = dd(int)
ans = 0
is_including_c = False

ate[c] += 1

for i in range(k):
    ate[li[i]] += 1

while True:
    ans = max(ans, len(ate.keys()))

    if left < n:
        ate[li[left]] -= 1
        if ate[li[left]] == 0: del ate[li[left]]
        left += 1
        right += 1
        ate[li[right % n]] += 1
    else:
        break

print(ans)




    # 벨트 순회
    # ate 딕셔너리 수정
