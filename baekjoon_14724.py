# 동아리 이름 club_name_list에 넣어두고
# 빈 딕셔너리 하나 선언
# n 에 부원 수 값 넣어두고

# for idx in range(9): 9개 클럽 돌리기
# list(map(int, input().split()))으로 부원 정보 받음
# 반복문 돌면서 딕셔너리에 D[club_name_list[i]] = max(num_list) 입력
# D[club_name_list[i-1] 과 D[club_name_list[i] 크기 비교하여 이긴놈 ans 에 저장

# print(ans)

club_name_list = ["PROBRAIN", "GROW", "ARGOS", "ADMIN", "ANT", "MOTION", "SPG", "COMON", "ALMIGHTY"]
D = dict()
n = int(input()) # 동아리 부원 수
ans = ""
temp = 0

for idx in range(9):
    score_list = list(map(int, input().split()))
    D[club_name_list[idx]] = max(score_list)
    if D[club_name_list[idx]] > temp:
        temp = D[club_name_list[idx]]
        ans = club_name_list[idx]
print(ans)
