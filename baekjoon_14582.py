# 제미니스가 이긴 적이 있는 경우의 flag

# 승부 총점에서 제미니스가 진 경우 && flag == 1 이라면 print YES
# 아니면 NO

# '첫 번째 시도 실패 후 수정사항' : 자신의 이닝중에 이기고 있었으면 이기고 있었던 거라서
# flag 판단문을 sum 중간에 넣어서 이닝 순서 구별


score_a = list(map(int, input().split()))
score_b = list(map(int, input().split()))
sum_a, sum_b = 0, 0
flag = 0

for i in range(9):
    sum_a += score_a[i]
    if sum_a > sum_b:
        flag = 1
    sum_b += score_b[i]
if sum_a < sum_b and flag == 1:
    print("Yes")
else:
    print("No")