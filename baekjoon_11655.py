s = list(input())
for i in range(len(s)):
    t = ord(s[i])
    if 65 <= t <= 90 or 97 <= t <= 122:
        if s[i].isupper(): t -= 65
        else: t -= 97
        t += 13
        t %= 26
        if s[i].isupper(): t += 65
        else: t += 97
        s[i] = chr(t)
print(''.join(s))
