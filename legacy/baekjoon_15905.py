# 5등과 푼 문제 수는 같지만 패널티 차이로 수상하지 못한 학생들의 수 출력
n = int(input())
li = list()
for i in range(n):
    li.append(list(map(int, input().split())))
li.sort(key = lambda x: [-x[0], x[1]])

cnt = 0
for i in range(n):
    li[i].append(i+1) # 등수 추가
    if i+1 > 5 and li[4][0] == li[i][0] and li[4][1] != li[i][1]:
        cnt += 1
print(cnt)