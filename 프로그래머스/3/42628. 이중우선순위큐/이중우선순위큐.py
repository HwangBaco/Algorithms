import heapq

def solution(operations):
    answer = []
    for str in operations:
        cmd, val = str.split(" ")
        if (cmd == "I"):
            heapq.heappush(answer, int(val))
        elif (val == "1" and len(answer) > 0):
            m = max(answer)
            answer.remove(m)
        elif (val == "-1" and len(answer) > 0):
            heapq.heappop(answer)
    if len(answer) == 0:
        answer.append(0)
        answer.append(0)
    else:
        answer = [max(answer), heapq.heappop(answer)]
    return answer