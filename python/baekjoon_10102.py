from itertools import combinations as cb
arr = list()
for _ in range(9):
    arr.append(int(input()))
for case in cb(arr, 7):
    # print(sum(case))
    if sum(case) == 100:
        ans = sorted(case)
        print('\n'.join(map(str, ans)))
        break