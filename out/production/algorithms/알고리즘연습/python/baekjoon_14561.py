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
        is_index_error = 0
        for i in range(len(result)//2):
            if result[i] == result[-1-i]: is_index_error = 1
            else :
                is_index_error = 0
                break
    print(is_index_error)