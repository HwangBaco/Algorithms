import math

D = {0: 0, 1: 0, 2: 0, 3: 0, 4: 0, 5: 0, 7: 0, 8: 0, 69: 0}
li = list()
result = 1

s = input().strip()

for idx in s:
    if idx == '6' or idx == '9':
        # print("69 check")
        D[69] += 1
    else:
        D[int(idx)] += 1
for key in D:
    if key == 69:
        D[key] = math.ceil(D[key] / 2)
        li.append(D[key])
        # print(D[key])
    else:
        li.append(D[key])

print(max(li))




# D = {0: 0, 1: 0, 2: 0, 3: 0, 4: 0, 5: 0, 7: 0, 8: 0, 69: 0}
# result = 1
#
# s = input().strip()
#
# for idx in s:
#     if idx == '6' or idx == '9':
#         if D[69] == 2:
#             result += 1
#             D[69] = 1
#         else:
#             D[69] += 1
#     else:
#         if D[int(idx)] == 1:
#             result += 1
#         else:
#             D[int(idx)] = 1
# print(result)
#
