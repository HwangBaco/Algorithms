li = []
for _ in range(9):
    li.append(int(input()))
print(max(li)) # 최댓값
print(li.index(max(li))+1) # 문자열은 find, 리스트는 index