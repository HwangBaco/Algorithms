while True:
    a, b, c, d = map(int, input().split())
    # loop-break when 0,0,0,0
    if a == 0 and b == 0 and c == 0 and d == 0:
        break
    li = [c-b, d-a]
    print(' '.join(map(str, li)))