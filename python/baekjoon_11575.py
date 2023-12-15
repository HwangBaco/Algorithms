for i in range(int(input())):
    a, b = map(int, input().split())
    s = list(input())
    for j in range(len(s)):
        x = ord(s[j])
        x -= 65
        x = a*x + b
        x %= 26
        x += 65
        s[j] = chr(x)
    print(''.join(s))