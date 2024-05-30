from sys import setrecursionlimit
setrecursionlimit(10000)

res = [[], []]

def go(nodeinfo):
    if not nodeinfo:
        return
    root = (0, 0, -1) # i, n, y
    for i, (n, x, y) in enumerate(nodeinfo):
        if root[-1] < y:
            root = (i, n, y)
    
    res[0].append(root[1]) # 전위순회
    left, right = nodeinfo[:root[0]], nodeinfo[root[0]+1:]
    go(left), go(right)
    res[1].append(root[1])
    

def solution(nodeinfo):
    nodeinfo = sorted([(i+1, x, y) for i, (x, y) in enumerate(nodeinfo)], key=lambda x: x[1])
    go(nodeinfo)
    return res
