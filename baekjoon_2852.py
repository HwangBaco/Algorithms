A_win_time = 0
B_win_time = 0
flag = 0
for i in range(int(input())):
    team_number, time = input().split()
    m, s = map(int, time.split(':'))
    if team_number == '1':
        if flag == 0:
            A_win_time += 48 * 60 - (60 * m + s)
        flag += 1
        if flag == 0:
            if B_win_time > 0:
                B_win_time = B_win_time - (48 * 60 - (60 * m + s))
    else:
        if flag == 0:
            B_win_time += 48 * 60 - (60 * m + s)
        flag -= 1
        if flag == 0:
            if A_win_time > 0:
                A_win_time = A_win_time - (48 * 60 - (60 * m + s))

print('{:0>2}:{:0>2}'.format(A_win_time // 60, A_win_time % 60))
print('{:0>2}:{:0>2}'.format(B_win_time // 60, B_win_time % 60))
