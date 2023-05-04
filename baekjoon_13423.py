"""첫번째 풀이"""

# from itertools import combinations as cb
#
# for _ in range(int(input())*2):
#     n = int(input()) # num of points
#     li = list(map(int, input().split()))
#     ans = 0
#     for _li in cb(li, 3):
#         _li = sorted(list(_li))
#         if (_li[1] - _li[0]) == (_li[2] - _li[1]): ans += 1
#     print(ans)

# """두번째 풀이"""
# import sys
# input = sys.stdin.readline
#
# for _ in range(int(input())):
#     n = int(input())
#     li = sorted(list(map(int, input().split())))
#     ans = 0
#     li.sort()
#
#     for i in range(n-1):
#         for j in range(i+1, n):
#             first = li[i]
#             # print(first) # test
#             second = li[j]
#             # print(second) # test
#             third = 2*second - first
#             # print(third) # test
#             if third in li[j+1:]: ans += 1
#             # print(li[j+1:])
#     print(ans)

# """세번째 풀이"""
# from collections import defaultdict
# import sys
# input = sys.stdin.readline
#
# for _ in range(int(input())):
#     n = int(input())
#     li = sorted(list(map(int, input().split())))
#     ans = 0
#     dd = defaultdict(int)
#     for i in li: dd[i] = 1
#     # for i in range(len(li)): dd[li[i]] = 1 # 위 식에서 변경
#
#     for i in range(n-1):
#         for j in range(i+1, n):
#             first = li[i]
#             second = li[j]
#             third = 2*li[j] - li[i]
#             if dd[third] == 1: ans += 1
#     print(ans)

"""(이진탐색) 첫 번째 풀이-시간초과"""
t = int(input())
for i in range(t):
    n = int(input())
    li = sorted(list(map(int, input().split())))
    # print(li)
    ans = 0

    for i in range(len(li)-2):
        for j in range(i+2, len(li)):
            if li[i] != li[j]:
                mid = (li[i]+li[j])//2
                flag = (li[i]+li[j])%2
                # print(li[i],mid, li[j])
                if mid in li and not flag: ans += 1
    print(ans)

"""(이진탐색) 두 번째 풀이"""
import sys
input = sys.stdin.readline

t = int(input())
for _ in range(t):
    n = int(input())
    li = sorted(list(map(int, input().split())))
    ans = 0
    for i in range(len(li)-2):
        for j in range(i+2, len(li)):
            left = i
            right = j
            target = (li[left]+li[right]) / 2
            while left <= right:
                mid_idx = (left + right) // 2
                if li[mid_idx] == target: ans += 1; break
                elif li[mid_idx] < target: left = mid_idx+1
                elif li[mid_idx] > target: right = mid_idx-1
    print(ans)
