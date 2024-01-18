# 부모와 자식 : 1촌
# 사람들은 1, 2, 3, ... , n (1 <= n <= 100)의 연속된 번호로 각각 표시된다.

import sys
input = sys.stdin.readline
from collections import deque as dq

def bfs(graph, start, destination, visited):
    global ans
    queue = dq([start])
    while queue:
        v = queue.popleft()
        for i in graph[v]:
            if not visited[i]:
                queue.append(i)
                visited[i] += visited[v]+1

# 입력: 전체 사람 수 n
n = int(input())
# 기본 변수:
graph = [[] for i in range(n+1)]
visited = [0] * (n+1)
# 입력: 촌수를 계산할 서로 다른 두 사람의 번호가 주어진다.
start, destination = map(int, input().split())
# 입력: 부모 자식들 간의 관계의 개수 m
m = int(input())
# 입력: 부모, 자식 관계
for _ in range(m):
    parent, child = map(int, input().split())
    graph[parent].append(child)
    graph[child].append(parent)
bfs(graph, start, destination, visited)
print(visited[destination] if visited[destination] > 0 else -1)