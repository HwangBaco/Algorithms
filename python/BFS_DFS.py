from collections import deque
def bfs(start): # BFS 방법으로
    global adj
    dq = deque()
    dq.append(start)
    visited_bfs[start] = 1
    while dq:
        ans = dq.popleft()
        print(ans, end=' ') # 출력이 핵심
        for i in adj[start]: # 인근 노드에 방문을 할 건데
            num = int(''.join(map(str,i)))
            if not visited_bfs[num]: # 만약 i번 노드가 현재 위치랑 연결이 되어있고 and i번 노드에 방문을 안했으면
                dq.append(num)
                visited_bfs[num] = 1
def dfs(start):
    global visited_dfs
    global adj
    ans = list()
    ans.append(start)
    visited_dfs[start] = 1
    for i in adj[start]:
        if not visited_dfs[i]:
            dfs(i)
            visited_dfs[i] = 0
    print(ans)

n, m, v = map(int, input().split())
adj = [[0],[1,3,4],[1,4],[1,4],[1,2,3]]
visited_bfs = [0,0,0,0,0]
visited_dfs = [0,0,0,0,0]
for _ in range(m):
    a, b = map(int, input().split())
    a -= 1; b -= 1
    adj[a].append([b])
    adj[b].append([a])

# bfs
dfs(v)
bfs(v)


