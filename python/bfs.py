"""
파이썬의 BFS는 그래프에 대한 넓/이/우/선/탐/색 입니다.

구현 과정은 기본적으로 큐를 이용하게 되며, 현실적으론 deque를 사용하면 된다.

그래프를 받을 때, 각 노드의 번호를 인덱스와 일치시키고, 각 노드의 엣지를
리스트에 등록해둬야 한다. 만약 (3,7)이면 li[3].append(7) and li[7].append(3)

그리고 일반적인 경우, deque에 append하는 순간은 해당 그래프의 노드를 들르는 순간과 같으므로
visited[i]에도 True를 먹여줘야 한다.
"""

from collections import deque

def bfs(graph, start, visited):
    queue=deque([start])
    visited[start] = True
    while queue:
        v = queue.popleft()
        # print(v, end=' ')
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