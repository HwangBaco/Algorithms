"""참고한 풀이"""
# def go(arr, ans):
#     if len(ans) == m:
#         print(' '.join(map(str, ans)))
#         return
#     for i in arr:
#         if i not in ans:
#             go(arr, ans+[i])
# n, m = map(int, input().split())
# arr = sorted(list(map(int, input().split())))
# go(arr, [])

"""혼자 푼 풀이"""
n, m = map(int, input().split())
li = sorted(list(map(int, input().split())))
visited = [0] * n
ans = [0] * m
def is_promise(x):
    if visited[x]: return False
    return True
def go(x):
    if x == m:
        res = ' '.join(map(str, ans))
        print(res)
        return
    else:
        for i in range(len(li)):
            ans[x] = li[i]
            if is_promise(i):
                visited[i] = 1
                go(x+1)
                visited[i] = 0
go(0)