import sys
input = sys.stdin.readline

def inRange(x, n):
    return x >= n and x <= (n * 26)

n, x = map(int, input().split())
s = ""
if (not inRange(x, n)):
    print("!")
else:
    last = int(x / 26)
    if last > 0:
        s = s + ("Z" * last)
    temp = (n - len(s) - 1)
    print(temp)
    if(x % 26 > 0 and temp >= 0):
        s = chr(x%26 + 64 - temp) + s
    if temp > 0:
        s = "A" * temp + s
    print(s)