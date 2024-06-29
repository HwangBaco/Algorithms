def solution(distance, rocks, n):
    global gaps
    rocks.sort()
    rocks.append(distance)
    
    left = 0
    right = 10**9
    answer = 0
    while left < right:
        mid = (left + right) // 2
        current = 0
        remove_cnt = 0
        min_dist = 10**18
        for r in rocks:
            if r - current < mid:
                remove_cnt += 1
            else:
                min_dist = min(min_dist, r - current)
                current = r
                
        if remove_cnt > n:
            right = mid
        else:
            answer = min_dist
            left = mid + 1
    return answer
