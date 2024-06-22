from collections import deque
import sys
input = sys.stdin.readline

def bfs(target):
    q = deque()
    visited = [False] * (N+1)
    visited[S] = True
    q.append(S)
    while q:
        now = q.popleft()
        for nv, w in adj[now]:
            if not visited[nv] and w >= target:
                if nv == E:
                    return True
                q.append(nv)
                visited[nv] = True
    return False

N, M = map(int, input().split())
adj = [[] for _ in range(N+1)]
for _ in range(M):
    A, B, C = map(int, input().split())
    adj[A].append([B, C])
    adj[B].append([A, C])
S, E = map(int, input().split())

left = 0
right = int(1e9)
ans = -1
while left <= right:
    mid = (left + right) // 2
    if bfs(mid):
        ans = max(ans, mid)
        left = mid + 1
    else:
        right = mid - 1
print(ans)