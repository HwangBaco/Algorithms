from collections import defaultdict as dd

# 팀원 수를 받는다.
n = int(input())
# 점수 배열을 받는다.(2차원 리스트)
board = list()
for i in range(n):
    board.append(list(map(int, input().split())))

# 기본 변수 선언
start_score = 0
link_score = 0
res_arr = list()
choice = dd()

# 멤버 리스트 init
members = [i for i in range(1, n+1)]

# test
print(n)
print(board)
print(members)

# 백트래킹 로직 생각
# ---------------
# 한명씩 뽑는 로직
# 만약 필요 없는 사람이라면(is_promising) 패스 ; 필요 없는 사람은 두번 째 사람을 뽑을 때 점수 계산시 이미 있는 경우
# 스타트팀 다 뽑으면 members 이용해서 나머지 링크팀 배정
# 뽑은 사람을 이용하여 점수 계산, return

# 점수차 절댓값으로 res_arr에 추가
