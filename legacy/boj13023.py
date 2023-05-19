"""
사람 수 N : 5 <= N <= 2,000
친구 관계 수 M : 1 <= M <= 2,000

"""
def dfs(graph, node, visited, depth):
    global ans
    if depth == 5: ans = 1; return
    for i in graph[node]:
        if not visited[i]:
            visited[node] = True
            dfs(graph, i, visited, depth+1)
            visited[i] = False

N, M = map(int, input().split())
graph = [[] for _ in range(N)]
visited = [False] * N
ans = 0
for _ in range(M):
    a, b = map(int, input().split())
    graph[a].append(b)
    graph[b].append(a)

for i in range(N):
    visited[i] = True
    dfs(graph, i,visited, 1)
    visited[i] = False

print(ans)