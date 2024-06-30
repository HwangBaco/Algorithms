n = int(input())
li = list(map(int, input().split()))

lis = []

def bs(target):
    left = 0
    right = len(lis) - 1
    while left < right:
        mid = (left + right) // 2
        if lis[mid] > target:
            right = mid
        elif lis[mid] == target:
            return mid
        else:
            left = mid + 1
    return left

for i in li:
    if len(lis) == 0:
        lis.append(i)
    else:
        if lis[-1] < i:
            lis.append(i)
        else:
            lis[bs(i)] = i
print(len(lis))