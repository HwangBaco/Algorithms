n, m = map(int, input().split())
ans = list()
for i in range(m):
    result = str(n * (i+1)).rstrip('0')
    ans.append(int(result[::-1]))
print(max(ans))