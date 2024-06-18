dy = [1, -1, 0, 0]
dx = [0, 0, 1, -1]
grid = []
visited = []

def dfs(v):
    for i, nv in enumerate(grid[v]):
        if nv == 1 and not visited[i]:
            visited[i] = True
            dfs(i)

def solution(n, computers):
    global N
    global grid
    global visited
    answer = 0
    N = n
    visited = [False for _ in range(N)]
    grid = computers

    for i in range(N):
        for nv in grid[i]:
            if nv == 1 and not visited[i]:
                answer += 1
                visited[i] = True
                dfs(i)
    
    return answer