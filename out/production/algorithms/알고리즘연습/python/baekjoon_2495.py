for _ in range(3):
    li = [1]
    s = input()
    cnt = 1
    for i in range(len(s)):
        if i > 0 and s[i] == s[i-1]:
            cnt += 1
            li.append(cnt)
        else:
            cnt = 1
    print(max(li))