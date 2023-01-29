n = int(input()) # 피연산자의 개수
exp = list(input()) # 후위 표기식
cal = ['*', '+', '/', '-']
s = list()
d = dict()
for i in range(n):
    d[chr(i+65)] = int(input())
for i in exp:
    if i in d:
        s.append(d[i])
    elif i in cal:
        o1 = s.pop()
        o2 = s.pop()
        if i == '+': res = o2 + o1
        elif i == '-':
            res = o2 - o1
            # print(o2, o1, res)
        elif i == '/': res = o2 / o1
        elif i == '*': res = o2 * o1
        s.append(res)
print(f"{round(res,2): .2f}".lstrip())