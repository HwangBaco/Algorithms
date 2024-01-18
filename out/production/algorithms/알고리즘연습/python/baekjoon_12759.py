arr = [[' '] * 3 for _ in range(3)]

p = int(input())
while 1:
    x, y = map(int, input().split())
    x -= 1
    y -= 1
    winner = 0

    # 보드판에 O, X 그리기
    if p == 1:
        arr[x][y] = 'O'
    else:
        arr[x][y] = 'X'

    # 승부가 결정났는지 확인하기
    res = []

    for i in range(3):
        res.append([arr[i][0], arr[i][1], arr[i][2]])

    for i in range(3):
        res.append([arr[0][i], arr[1][i], arr[2][i]])

    res.append([arr[0][0], arr[1][1], arr[2][2]])
    res.append([arr[0][2], arr[1][1], arr[2][0]])

    if ['O', 'O', 'O'] in res: winner = 1
    if ['X', 'X', 'X'] in res: winner = 2

    if winner == 0:
        is_index_error = False  # 공백이 있으면 True, 없으면 False
        for i in range(len(res)):
            if ' ' in res[i]: is_index_error = True
        if not is_index_error: winner = 3

    # 승부가 결정되었을 때
    if winner > 0: break

    # 턴 넘기기
    if p == 1:
        p = 2
    else:
        p = 1

if winner < 3:
    print(winner)
else:
    print(0)