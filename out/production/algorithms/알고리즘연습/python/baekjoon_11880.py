from itertools import permutations as pm
import sys
input = sys.stdin.readline

T = int(input())
for _ in range(T):
    arr = list(map(int, input().split()))
    ans = list()
    for a, b, c in pm(arr, 3):
        res = a ** 2 + (b + c) ** 2
        ans.append(res)
    print(min(ans))