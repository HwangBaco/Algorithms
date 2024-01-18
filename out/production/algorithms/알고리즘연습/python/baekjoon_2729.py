for _ in range(int(input())):
    a, b = map(str, input().split())
    la = len(a)
    lb = len(b)
    if la - lb > 0:
        gap = la - lb
        b = '0'*gap + b
        # print(a, b) # test
    else:
        gap = lb - la
        a = '0'*gap + a
        # print(a, b) # test
    ans = []
    carry = 0
    for i in range(1, len(a)+1):
        if a[-i] == '0' and b[-i] == '0' and carry == 0:
            ans.append('0')
            # print(a[-i], b[-i])
            # print(''.join(map(str,ans[::-1])))
        elif a[-i] == '1' and b[-i] == '0' and carry == 0:
            ans.append('1')
            # print(a[-i], b[-i])
            # print(''.join(map(str,ans[::-1])))
        elif a[-i] == '0' and b[-i] == '1' and carry == 0:
            ans.append('1')
            # print(a[-i], b[-i])
            # print(''.join(map(str,ans[::-1])))
        elif a[-i] == '1' and b[-i] == '1' and carry == 0:
            ans.append('0')
            carry = 1
            # print(a[-i], b[-i])
            # print(''.join(map(str,ans[::-1])))
        elif a[-i] == '0' and b[-i] == '0' and carry == 1:
            ans.append('1')
            carry = 0
            # print(a[-i], b[-i])
            # print(''.join(map(str,ans[::-1])))
        elif a[-i] == '1' and b[-i] == '0' and carry == 1:
            ans.append('0')
            carry = 1
            # print(a[-i], b[-i])
            # print(''.join(map(str,ans[::-1])))
        elif a[-i] == '0' and b[-i] == '1' and carry == 1:
            ans.append('0')
            carry = 1
            # print(a[-i], b[-i])
            # print(''.join(map(str,ans[::-1])))
        elif a[-i] == '1' and b[-i] == '1' and carry == 1:
            ans.append('1')
            carry = 1
            # print(a[-i], b[-i])
            # print(''.join(map(str,ans[::-1])))
    if carry:
        ans.append('1')
    # print(ans[::-1]) # test
    while 1:
        if len(ans) > 0 and ans[-1] == '0':
            ans.pop()
        else:
            break
    if len(ans) > 0:
        print(''.join(map(str,ans[::-1])))
    else:
        print(0)