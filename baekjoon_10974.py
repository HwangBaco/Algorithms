from itertools import permutations as pm

n = int(input())
arr = [i for i in range(1, n+1)]

for t in pm(arr, n):
    print(' '.join(map(str, t)))
