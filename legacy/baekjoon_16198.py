import sys
sys.setrecursionlimit(10000)
input = sys.stdin.readline

# ans = list()
# n = int(input())
# li = list(map(int, input().split()))
# res = 0

# def go(n):
#     global ans, res
#     if n == 2: ans.append(res); res = 0; return
#     else:
#         for i in range(1, n-1):
#             res += li[i-1] * li[i+1]
#             temp = li.pop(i)
#             go(n-1)
#             li.insert(i, temp)
# go(n)
# print(max(ans))

def go(val):
    global ans
    if len(li) == 2:
        if val > ans: ans = val
        return
    else:
        for i in range(1, len(li)-1):
            res = li[i-1] * li[i+1]
            temp = li.pop(i)
            go(val + res)
            li.insert(i, temp)
ans = 0
n = int(input())
li = list(map(int, input().split()))
go(0)
print(ans)
