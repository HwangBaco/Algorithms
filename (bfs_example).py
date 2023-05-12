from collections import deque

def bfs(graph, start, visited):
    queue=deque([start])
    visited[start] = True
    while queue:
        v = queue.popleft()
        print(v, end=' ')
        for i in graph[v]:
            if not visited[i]:
                queue.append(i)
                visited[i] = True

graph = [
    [1,2], #0번 노드에서 1과 2로 이동 가능하다.
    [3, 4, 5], #1번 노드에서 2,3,8로 이동 가능하다.
    [6,7], #2번 노드에서 1,7로 이동 가능하다.
    [8],
    [3],
    [],
    [],
    [],
    []
]

visited = [False] * 9

bfs(graph, 0, visited) #출력 : 0 1 2 3 4 5 6 7 8