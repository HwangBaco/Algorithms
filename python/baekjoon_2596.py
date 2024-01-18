n = int(input())
s = input()

d = {"000000":"A", "001111":"B", "010011":"C", "011100":"D", "100110":"E", "101001":"F", "110101":"G", "111010":"H"}

li = list()
ans = list()
cnt = 0
for i in range(n):
    li.append(s[6*i : 6*i + 6])

for elem in li:
    cnt += 1
    # print(elem)
    if elem in d.keys():
        ans.append(d[elem])
    else:
        new_one = ""
        for i in range(6):
            if elem[i] == "0":
                new_one = elem[:i] + "1" + elem[i+1:]
            elif elem[i] == "1":
                new_one = elem[:i] + "0" + elem[i+1:]

            if new_one in d.keys():
                ans.append(d[new_one])
                break
        if len(ans) != cnt: break
if len(ans) == n:
    print(''.join(ans))
else:
    print(cnt)