# 야근 피로도 : 야근 시작 시점에서 남은 일의 작업량을 제곱하여 더한 값
# N시간 동안 야근 피로도를 최소화한 값을 리턴
# 그리디 - 최대값과 최소값의 차가 1 이하가 되도록 최대값을 --함
# -> 정렬 상태를 유지하기 위해 우선순위 큐 사용
import heapq

def solution(n, works):
    pq = []
    
    for i in works:
        heapq.heappush(pq, -i)
    
    for _ in range(n):
        max_v = -heapq.heappop(pq)
        max_v -= 1
        heapq.heappush(pq, -max_v)
    
    answer = 0
    
    for i in pq:
        if -i <= 0:
            continue
        answer += i * i
    return answer