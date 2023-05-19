import sys
input = sys.stdin.readline

t = int(input())
ans = list()
for i in range(t):
    n, m = map(int, input().split())
    a = sorted(list(map(int, input().split())), key= lambda x:-x)
    b = sorted(list(map(int, input().split())))

    res = 0
    for j in a:
        for k in b:
            if j > k: res += 1
            else:
                break
        if j <= k:
            continue
    ans.append(res)
print('\n'.join(map(str,ans)))