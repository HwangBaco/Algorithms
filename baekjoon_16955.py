board = list()
o_cnt, x_cnt = 0, 0
o_idx_arr, x_idx_arr = [], []
for i in range(10):
    board.append(list(input()))
    o_cnt += board[i].count("O")
    x_cnt += board[i].count("X")

if o_cnt + x_cnt <= 6:
    print(0)
else:
    for y in range(10):
        for x in range(10):
            if board[y][x] == "X": x_idx_arr.append([x,y])
            elif board[y][x] == "O": o_idx_arr.append([x,y])

