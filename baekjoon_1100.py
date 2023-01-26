mtrx = list()
cnt = 0
for i in range(8):
    mtrx.append(list(input()))
    for j in range(8):
        if i % 2 == 0 and j % 2 == 0:
            if mtrx[i][j] == 'F' : cnt += 1
        elif i % 2 == 1 and j % 2 == 1:
            if mtrx[i][j] == 'F' : cnt += 1
print(cnt)
# 2차원 리스트에 모든 문자를 넣고
# 짝수 행에서는 if 짝수 인덱스값 == F : cnt += 1
# 홀수 행에서는 if 홀수 인덱스값 == F : cnt += 1
# print(cnt)