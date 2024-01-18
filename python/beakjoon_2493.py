"""
백준 2493. 탑

n = int(input()) # 탑의 수
li = list(map(int, input().split())) # 탑의 높이

ans = [0] * (n+1)
stack = []

for i in range(len(li)):
    while stack and li[stack[-1]] < li[i]:
        stack.pop()
    if stack: ans[i] = stack[-1]
    else: ans[i] = 0
    stack.append(i)
print(ans)


"""
n = int(input()) # 탑의 수
li = list(map(int, input().split())) # 탑의 높이

ans = [0] * (n)
stack = []

for i in range(len(li)):
    while stack and li[stack[-1]] < li[i]:
        stack.pop()
    if stack: ans[i] = stack[-1] +1
    else: ans[i] = 0
    stack.append(i)
print(*ans)

