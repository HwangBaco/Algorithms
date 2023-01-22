val = {i:str(i) for i in range(10)}
val.update({i+10: chr(i+97) for i in range(26)})

n = int(input())
ans = list()

while n != 0:
    ans.append(val[n % 2])
    n //= 2
result = ''.join(map(str, ans))
print(int(result, 2))