import sys
input = sys.stdin.readline
def hanoi_res(n):
    if n == 1:
        return 1
    res = 1
    for i in range(1,n):
        res = res * 2 + 1
    return res

def convert(li, a, b):
    ret = list()
    for i, j in li:
        if i == a: i = b
        elif i == b: i = a
        if j == a: j = b
        elif j == b: j = a
        ret.append((i, j))
    return ret
def hanoi_mov(n, tmp):
    if n == 1:
        return tmp
    for i in range(1,n):
        tmp = [*convert(tmp, 2, 3), (1, 3), *convert(tmp, 1, 2)]
    return tmp

n = int(input())

print(hanoi_res(n))
if n <= 20:
    for i in hanoi_mov(n, [(1,3)]):
        print(*i)
