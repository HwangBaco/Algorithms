from collections import deque as dq
def bfs(node):
    queue.append(node)
    visited[node] = True
    while queue:
        v = queue.popleft()
        for i in graph[v]:
            if not visited[i]:
                queue.append(i)
                visited[i] = True

N, M = map(int, input().split())
queue = dq([])
visited = [False] * (N+1)
graph = [[] for _ in range(N+1)]
ans = 0

for _ in range(M):
    u, v = map(int, input().split())
    graph[u].append(v)
    graph[v].append(u)

for i in range(1, N+1):
    if not visited[i]:
        bfs(i)
        ans += 1
print(ans)