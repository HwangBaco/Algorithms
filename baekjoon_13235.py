s = input()
flag = True

for i in range(len(s)//2):
    if s[i] != s[-1-i]:
        flag = False
print(str(flag).lower())