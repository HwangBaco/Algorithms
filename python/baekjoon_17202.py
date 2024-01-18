# 휴대폰 번호를 둘 다 받는다.
# 휴대폰 번호를 하나하나 번갈아가면서 문자열을 만든다.
# 합친 문자열을 하나하나 탐색하면서 [i]와 [i+1]을 더한걸 결과 리스트에 저장해둔다.
# 만약 i+1 == len(arr) - 1이라면 멈춘다.
# if 합친 문자열 길이가 2라면, 출력한다.

import sys
input = sys.stdin.readline

a = input()
b = input()
tmp = [] # 합친 문자열

for i in range(8):
    tmp.append(a[i])
    tmp.append(b[i])
while 1:
    if len(tmp) == 2: print(''.join(tmp)); break
    res = [] # 결과 리스트
    for i in range(len(tmp)-1):
        num = str(int(tmp[i]) + int(tmp[i+1]))
        res.append(num[-1])
    tmp = res