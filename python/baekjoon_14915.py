val = {i:str(i) for i in range(10)}
val.update({i+10:chr(i+97) for i in range(26)})

m, n = map(int, input().split())
if m == 0: print(0)
else:
    ans = list()
    while m != 0:
        ans.append(val[m % n])
        m //= n
    print(''.join(map(str,ans[::-1])).upper())