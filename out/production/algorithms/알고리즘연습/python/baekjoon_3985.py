L = int(input()) # 롤 케이크의 길이
N = int(input()) # 방청객의 수
li = list() # 기대하는 조각의 길이 리스트
d = dict() # 실제 차지한 조각 딕셔너리
for guest in range(1, N+1):
    p, k = map(int, input().split()) # 종이에 적어낸 조각의 범위
    li.append(k - p)
    for i in range(p, k+1):
        if i in list(d.keys()):
            # print("pass")
            continue
        else:
            d[i] = guest

print(li.index(max(li)) + 1) # 가장 많은 조각을 받을 것으로 기대하고 있던 방청객의 번호
# print(list(d.values()))
result = list()
for guest in range(1, N+1):
    result.append(list(d.values()).count(guest))
print(result.index(max(result))+1)