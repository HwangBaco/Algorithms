n, k = map(int, input().split()) # n: 국가 수, k: 등수를 알고 싶은 국가

# 국가 : 1부터 n 사이의 정수로 표현됨
# 등수 : 자신보다 더 잘한 나라 수 + 1

# 각 국가의 금,은,동메달 정보를 입력받아서 어느 국가가 몇 등을 했는지 알려주는 프로그램
li = list()
for i in range(n):
    temp = list(map(int, input().split())) # idx, gold, silver, bronze
    temp.append(0) # 등수 매겨두기
    li.append(temp)

li.sort(key = lambda x: [-x[1], -x[2], -x[3]]) # 등수 기준 : 금메달, 은메달, 동메달 순으로 내림차순

grade = 2
cnt = 0
li[0][4] = 1
for i in range(1, n):
    if li[i-1][1] == li[i][1] and li[i-1][2] == li[i][2] and li[i-1][3] == li[i][3]:
        li[i][4] = grade - 1
        cnt += 1
    else:
        li[i][4] = grade + cnt
        cnt = 0
        grade += 1
for i in range(n):
    if li[i][0] == k:
        print(li[i][4])