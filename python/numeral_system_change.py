val = {i: str(i) for i in range(10)}
val.update({i+10: chr(97+i) for i in range(26)})
n = input() # 바꿀 수
ans = []
while 1:
    if n == 0: break
    x = n % 2 # 진법 (예시는 2진법)
    ans.append(val[x])
    n //= 2 # 진법 (예시는 2진법)
print(''.join(ans[::-1]))
