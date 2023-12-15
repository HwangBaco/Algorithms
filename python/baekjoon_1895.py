import sys
input = sys.stdin.readline

arr = list()
search = list()
filtered = list()
ans = 0

R, C = map(int, input().split())
for i in range(R):
    li = list(map(int, input().split()))
    arr.append(li)
threshold = int(input())

for i in range(R-2):
    for j in range(C-2):
        temp = arr[0+i][0+j:3+j]
        temp += arr[1+i][0+j:3+j]
        temp += arr[2+i][0+j:3+j]
        search.append(temp)
for i in range((R-2)*(C-2)):
    search[0+i].sort()
    filtered.append(search[0+i][4])

for i in filtered:
    if i >= threshold: ans += 1
print(ans)