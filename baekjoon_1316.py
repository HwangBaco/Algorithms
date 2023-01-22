# flag = 1
# 딕셔너리에 알파벳 별로 횟수 넣어두고
# if 이전 문자와 동일한 문자인가? : pass
# elif 딕셔너리 값에 0이라고 되어있는가? : pass
# else : flag = 0

# if flag == 1(위 조건을 전부 통과) : ans += 1
# else : pass


ans = 0

for _ in range(int(input())):
    flag = 1
    d = {chr(97+i) : 0 for i in range(26)}
    s = input()
    for i in range(len(s)):
        if i > 0 and s[i-1] == s[i]:
            pass
        elif d[s[i]] == 0:
            d[s[i]] += 1
        else:
            flag = 0
    if flag:
       ans += 1
    else:
        pass
print(ans)