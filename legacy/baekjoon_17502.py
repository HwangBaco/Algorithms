# 클레어와 팰린드롬
l = int(input())
s = list(input())

for i in range(l):
    if s[i] == '?' and s[-i-1] == '?':
        s[i], s[-i-1] = 'a', 'a'
    elif s[i] == '?':
        s[i] = s[-1-i]
    elif [-1-i] == '?':
        s[-1-i] = s[i]

print(''.join(s))