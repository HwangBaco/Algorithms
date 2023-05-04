import sys
input = sys.stdin.readline
val = {i : str(i) for i in range(10)}
val.update({i+10:chr(i+97) for i in range(26)})

n = int(input())
store = n
flag2 = True
for k in range(2, 11):
    is_index_error = True
    n = store
    res = ""
    ans = []
    while 1:
        if n == 0: break
        ans.append(val[n % k])
        n //= k
    res = ''.join(map(str, ans))
    # print(k, ans)
    # print(res)
    for i in range(len(res)//2):
        if res[i] != res[-1-i]:
            is_index_error = False
    if is_index_error:
        print(k, res)
        flag2 = False
if flag2:
    print("NIE")