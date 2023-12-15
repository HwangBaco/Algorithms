# n, m 입력받음
# n : 학생 수
# m : loop range

# a, b 입력받음
# 출력 : n번째 줄에 걸쳐서 각 학생의 친구 수 출력
n, m = map(int,input().split())

friend = [list() for i in range(n)]
for _ in range(m):
    a, b = map(int, input().split())
    a -= 1
    b -= 1
    friend[a].append(b)
    friend[b].append(a)

for i in range(n): print(len(friend[i]))