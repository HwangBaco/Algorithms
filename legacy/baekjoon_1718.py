cipher = list(input())
code = list(input())
k_idx = 0
for i in range(len(cipher)):
    x = ord(cipher[i])
    if 97 <= x <= 122:
        x -= (ord(code[k_idx % len(code)]) - 96)
        k_idx += 1
        if x < 97: x += 26
        cipher[i] = chr(x)
    else : k_idx += 1
print(''.join(cipher))
