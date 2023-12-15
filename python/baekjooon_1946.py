t = int(input())
for _ in range(t):
    n = int(input())
    li = list()
    for _ in range(n):
        li.append(list(input().split()))
        li.sort(key=lambda x: [x[0], x[1]])
    print(li)