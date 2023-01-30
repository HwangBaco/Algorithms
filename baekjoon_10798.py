li = []
length = []
for i in range(5):
    temp = list(input())
    li.append(temp)
    length.append(len(temp))
max_length = max(length)
# print(max_length)
for i in range(max_length):
    for j in range(5):
        try:
            print(li[j][i], end='')
        except:
            pass