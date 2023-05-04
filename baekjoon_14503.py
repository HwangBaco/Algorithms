def is_dirty_around(robot):
    global is_index_error
    crt_r = robot[0]
    crt_c = robot[1]
    try:
        if room[crt_c+1][crt_r] == 1:
            return True
    except IndexError:
        is_index_error = True
    try:
        if room[crt_c-1][crt_r] == 1:
            return True
    except IndexError:
        is_index_error = True
    try:
        if room[crt_c][crt_r+1] == 1:
            return True
    except IndexError:
        is_index_error = True
    try:
        if room[crt_c][crt_r-1] == 1:
            return True
    except IndexError:
        is_index_error = True
    return False

def move_back(robot):
    crt_r = robot[0]
    crt_c = robot[1]
    crt_h = robot[2]
    if crt_h == 0:
        if robot[1] >= 1:
            robot[1] -= 1
    elif crt_h == 1:
        if robot[2] >= 1:
            robot[2] -= 1
    elif crt_h == 2:
        if robot[1] < m-1:
            robot[1] += 1
    elif crt_h == 3:
        if robot[2] < n-1:
            robot[2] += 1

def move_around(robot):
    global is_index_error
    if robot[2] > 0:
        robot[2] -= 1
    else:
        robot[2] = 0
    if robot[2] == 0:
        try:
            if room[robot[1]+1][robot[2]] == 1:
                robot[1] += 1
        except IndexError:
            is_index_error = True
    elif robot[2] == 1:
        try:
            if room[robot[1]][robot[2]+1] == 1:
                robot[1] += 1
        except IndexError:
            is_index_error = True
    elif robot[2] == 2:
        try:
            if robot[1] < m-1:
                robot[1] += 1
        except IndexError:
            is_index_error = True
    elif robot[2] == 3:
        try:
            if robot[2] < n-1:
                robot[2] += 1
        except IndexError:
            is_index_error = True
# 1. 현재 칸이 아직 청소되지 않은 경우, 현재 칸을 청소한다.
# 2. 현재 칸의 주변 4칸 중 청소되지 않은 빈 칸이 없는 경우,
#   1. 바라보는 방향을 유지한 채로 한 칸 후진할 수 있다면 한 칸 후진하고 1번으로 돌아간다.
#   2. 바라보는 방향의 뒤쪽 칸이 벽이라 후진할 수 없다면 작동을 멈춘다.
# 3. 현재 칸의 주변 4칸 중 청소되지 않은 빈 칸이 있는 경우,
#   1. 반시계 방향으로 90도 회전한다.
#   2. 바라보는 방향을 기준으로 앞쪽 칸이 청소되지 않은 빈 칸인 경우 한 칸 전진한다.
#   3. 1번으로 돌아간다.

n, m = map(int, input().split())
robot = list(map(int, input().split())) # 0:r, 1:c, 2:h
room = list()
ans = 0
is_index_error = False
for i in range(n):
    room.append(list(map(int, input().split())))

while True:
    print(robot)
    print(is_index_error)
    if is_index_error: break
    if room[robot[1]][robot[0]] == 1:
        ans += 1
        room[robot[1]][robot[0]] = 0
    if not is_dirty_around(robot):
        move_back(robot)
        if is_index_error: break
    elif is_dirty_around(robot):
        move_around(robot)

print(ans)