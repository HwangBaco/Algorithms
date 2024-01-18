# val = {i:i for i in range(10)}
# val.update({i+10:chr(97+i) for i in range(26)})
# result = []
# n = 16
# while 1:
#     if n == 0: break
#     result.append(val[n % 2])
#     n //= 2
# print(''.join(map(str, result[::-1])))

t = int(input()) # 테스트 케이스의 개수
for n in range(t):
    str_size = int(input())
    s = input()
    print(f"Case #{n+1}: ", end='')
    for i in range(str_size):
        ans = list()
        for j in range(8):
            if s[i*8 + j] == "O": ans.append("0")
            else: ans.append("1")
        result = int(''.join(ans),2)
        print(chr(result), end='')
    print() # 개행