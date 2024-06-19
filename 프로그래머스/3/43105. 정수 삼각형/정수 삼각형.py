

def solution(triangle):
    # 다음 인덱스로 이동할 때, 현재 x 그대로 또는 +1만 이동 가능
    # 거쳐간 숫자의 최댓값을 return
    global N
    global grid
    grid = triangle
    N = len(triangle)
    
    for y in range(1,N):
        grid[y][0] += grid[y-1][0]
        grid[y][y] += grid[y-1][y-1]
    for y in range(1, N):
        for x in range(1,y):
            grid[y][x] += max(grid[y-1][x-1], grid[y-1][x])
    #print(grid)

    return max(grid[N-1])