val = {i:str(i) for i in range(10)}
val.update({i+10:chr(97+i) for i in range(26)})

n, b = map(int, input().split()) # n : 10진법 수, b : x진법
ans = []
while 1:
    if n == 0 : break
    ans.append(val[n % b])
    n //= b
print(''.join(ans[::-1]).upper())