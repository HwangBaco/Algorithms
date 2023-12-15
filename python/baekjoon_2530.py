import sys
input = sys.stdin.readline

h, m, s = map(int, input().split())
cook_time = int(input())

s += cook_time
while 1:
    if s >= 60:
        s -= 60
        m += 1
    else: break
while 1:
    if m >= 60:
        m -= 60
        h += 1
    else : break
while 1:
    if h >= 24:
        h -= 24
    else: break
print(h, m, s)

# a, b, c = map(int,input().split())
# d = int(input())
#
# x = (3600 * a + 60 *  b + c + d) % 86400
#
# h = x // 3600
# m = (x % 3600) // 60
# s = (x % 3600) % 60
#
# print(h, m, s)