"""
파이썬의 DFS는 깊/이/우/선/탐/색 으로,
구현할 때 재귀함수를 사용합니다.

참고: 트리 순환
"""

def dfs(graph, current_node, visited):
    visited[current_node] = True    # 현재 노드를 방문처리
    # print(current_node, end=' ')
    for i in graph[current_node]:   # 현재 노드와 연결된 다른 노드를 재귀적으로 방문
        if not visited[i]:
            dfs(graph, i, visited)

# 그래프 : 각 노드의 엣지를 표현
graph = [
    [1, 2],
    [3, 4, 5],
    [6, 7],
    [8],
    [3],
    [],
    [],
    [],
    []
]


