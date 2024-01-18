def binary_search(n, arr):
    left = 0
    right = len(arr)-1

    while left <= right:
        mid = int((left + right) / 2)
        if arr[mid] == n:
            return 1
        elif arr[mid] > n:
            right = mid - 1
        elif arr[mid] < n:
            left = mid + 1
    return 0
import sys
input = sys.stdin.readline

t = int(input())
li = sorted(list(map(int, input().split())))
q = int(input())
arr = list(map(int, input().split()))
for i in arr:
    print(binary_search(i, li))