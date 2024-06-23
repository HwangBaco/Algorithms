import sys
input = sys.stdin.readline

N = int(input())
li = sorted(list(map(int, input().split())))
# 산성 : 양수, 알칼리성 : 음수
# 세 용액의 혼합값이 0에 가장 가까운 용액을 만들려고 함
# 5,000 이하 개수

# 단순 풀이 : O(N^3) -> 시간초과

res = [10**9, 10**9, 10**9]
for i in range(N):
    left = i+1
    right = N-1
    while left < right:
        if abs(li[i] + li[left] + li[right]) < abs(sum(res)):
            res = [li[i], li[left], li[right]]
        if li[i] + li[left] + li[right] > 0:
            right -= 1
        elif li[i] + li[left] + li[right] < 0:
            left += 1
        else:
            break
print(*res)