

def solution(n):
    return go(n, 1, 3)

def go(depth, start, end):
    res = []
    mid = 6 - start - end
    
    if depth == 1:
        res += [[start, end]]
        return res
    else:
        res += go(depth-1, start, mid)
        res += [[start, end]]
        res += go(depth-1, mid, end)
        return res

    