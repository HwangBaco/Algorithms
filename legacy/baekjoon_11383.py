import sys
input = sys.stdin.readline

n, m = map(int, input().split())

if n == 1:
    s1 = list(input())
    s2 = list(input())

    res = ''.join([s1[i]*2 for i in range(m)]).strip()
    cmp = ''.join(s2).strip()
    # print(res, cmp) # test
    print("Eyfa" if res == cmp else "Not Eyfa")
else:
    s1 = [list(input()) for _ in range(n)]
    s2 = [list(input()) for _ in range(n)]
    is_equal = True
    for i in range(n):
        res = ''.join([s1[i][j]*2 for j in range(m)]).strip()
        cmp = ''.join(s2[i]).strip()
        # print(res, cmp)
        if res != cmp: is_equal = False; break
    print("Eyfa" if is_equal else "Not Eyfa")