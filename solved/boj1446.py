import heapq
import sys

# 입력 받기
n, d = map(int, input().split())
graph = [[] for _ in range(d+1)]
INF = int(1e9)
distance = [INF] * (d+1)

# 간선 정보 입력 받기
for _ in range(n):
    start, end, cost = map(int, sys.stdin.readline().split())
    if end > d:  # 도착점이 목표점을 넘어가면 무시
        continue
    graph[start].append((end, cost))

# 다익스트라 알고리즘 수행
def dijkstra(start):
    q = []
    heapq.heappush(q, (0, start))  # (비용, 노드)로 넣어줌
    distance[start] = 0
    
    while q:
        dist, now = heapq.heappop(q)
        if distance[now] < dist:  # 이미 처리된 노드는 무시
            continue
        for i in graph[now]:
            cost = dist + i[1]
            if cost < distance[i[0]]:
                distance[i[0]] = cost
                heapq.heappush(q, (cost, i[0]))
                
        if now < d:  # 노드에서 다음 노드로 걸어가는 경우
            if distance[now + 1] > dist + 1:  # 기존 비용보다 현재 비용이 더 작다면
                distance[now + 1] = dist + 1
                heapq.heappush(q, (dist + 1, now + 1))
                
dijkstra(0)

# 결과 출력
print(distance[d])
