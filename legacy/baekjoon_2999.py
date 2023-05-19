s = input()
n = len(s)

divisor = []
for i in range(1, n+1):
    if n % i == 0: divisor.append(i)

if len(divisor) % 2 == 0:
    r = divisor[len(divisor)//2 - 1]
    c = n // r
else:
    r = divisor[len(divisor)//2]
    c = n // r

arr = [[' ']*c for _ in range(r)]

for y in range(c):
    for x in range(r):
        arr[x][y] = s[r*y+x]

# #방법 1
# for x in range(r):
#     for y in range(c):
#         print(arr[x][y], end = '')

#방법 2
ans = []
for x in range(r):
    for y in range(c):
        ans.append(arr[x][y])
print(''.join(ans))