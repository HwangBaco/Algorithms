sensor = list()
for i in "CAMBRIDGE":
    sensor.append(i)

s = list(input())
i = 0
while 1:
    if i == len(s): break
    if s[i] in sensor:
        idx = s.index(s[i])
        # print(f"before pop : {s}")
        s.pop(idx)
        i -= 1
        # print(f"after pop : {s}")
    i += 1
print(''.join(s))