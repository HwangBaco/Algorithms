# 0 <= n <= 100
# 9 by 9 matrix
# 최댓값, 그 좌표 출력
mat = list()
max_li = list()
for _ in range(9):
    l = list(map(int, input().split()))
    max_li.append(max(l))
    mat.append(l)
max_num = max(max_li)
print(max_num)

for x in range(9):
    if max_num in mat[x]: print(x+1, mat[x].index(max_num)+1)
