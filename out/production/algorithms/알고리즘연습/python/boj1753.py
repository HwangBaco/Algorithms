"""
수빈 N : 0 <= N <= 100,000
동생 K : 0 <= K <= 100,000

수빈이는 걷거나 순간이동 가능
수빈이의 위치가 x일 때 걷는다면 단위 시간당 x-1, x+1로 이동 / 순간이동시 2x
수빈이와 동생의 위치가 주어졌을 때, 수빈이가 동생을 찾을 수 있는 가장 빠른 시간은?

DP
여러 경우의 수 중에서 가장 짧은 수를 찾으면 됨
작은 수에서 조절하고 두배 튕기고 하나 증감하는게 효율적임

이번에,
-1 : 한칸 전에 target이 있는 경우 or 두 배를 했을 때
+1 : 한칸 이후 target이 있는 경우 or 
x2
"""
import sys, heapq
input = sys.stdin.readline
from collections import deque as dq
"""BFS 풀이????"""
# def bfs():
#     queue.append(n)
#     while queue:
#         v = queue.popleft()
#         if v == k:
#             print(dist[v])
#             return
#         for next in (v-1, v+1, v*2):
#             if 0 <= next <= MAX and not dist[next]:
#                 dist[next] = dist[v] + 1
#                 queue.append(next)
# MAX = 10**5
# n, k = map(int, input().split())
# dist = [0] * (MAX+1)
# queue = dq()
#
# bfs()

"""Dijkstra 풀이"""
node, edge = map(int, input().split())
k = int(input())
INF =  int(1e10)
distance = [INF] * (node + 1)
graph = [[] for _ in range(node + 1)]
for i in range(edge):
    u, v, w = map(int, input().split())
    graph[u].append((v, w))
def dijkstra(start):
    q = []
    heapq.heappush(q, (0, start))
    distance[start] = 0
    while q:
        dist, now = heapq.heappop(q)
        # print(dist)
        if distance[now] < dist: continue
        for i in graph[now]:
            cost = dist + i[1]
            if cost < distance[i[0]]:
                distance[i[0]] = cost
                heapq.heappush(q, (cost, i[0]))

dijkstra(k)
for i in range(1, node+ 1):
    if distance[i] == INF: print("INF")
    else: print(distance[i])