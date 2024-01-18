def GCD(a,b):
    # a > b라고 가정
    while 1:
        res = a % b
        if res == 0: break
        a = b
        b = res
    return b

t = int(input())
li = sorted([int(input()) for i in range(t)])

_li = list()

for i in range(len(li)-1):
    _li.append(li[i+1]-li[i]) # B-A, ... 저장
_li.sort()

m = _li[0]
for i in range(1, len(_li)):
    m = GCD(_li[i], m)
ans = set()
for i in range(2, int(m**0.5)+1):
    if m % i == 0:
        ans.add(i)
        ans.add(m//i)
ans.add(m)
print(*sorted(ans))