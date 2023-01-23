val = {i:str(i) for i in range(10)}
val.update({i+10: chr(i+97) for i in range(26)})

for _ in range(int(input())):
    ans = list()
    n, b = map(int, input().split())
    while n != 0:
        ans.append(val[n%b])
        n //= b
        result = ''.join(ans[::-1])
        # print(result)
        flag = 0
        for i in range(len(result)//2):
            if result[i] == result[-1-i]: flag = 1
            else :
                flag = 0
                break
    print(flag)