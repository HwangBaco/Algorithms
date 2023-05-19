arr = list(map(str, input().split("-")))
ans = list()
for e in arr:
    ans.append(e[0])
print(''.join(ans))