s = input()
ans = list()
for char in s:
    x = ord(char)
    if 65 <= x <= 90:
        ans.append(chr(x+32))
    else:
        ans.append(chr(x-32))
print(''.join(ans))