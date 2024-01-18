li = list()

for i in range(int(input())):
    s = list(map(int, input().split()))
    s.insert(0, i+1)
    li.append(s)
li.sort(key = lambda x: [-x[1], x[2], x[3]])
print(li[0][0])