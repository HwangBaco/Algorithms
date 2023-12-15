while True:
    s = list(map(str, input().split()))
    if s[0] == "#": break
    for e in s:
        print(e[::-1], end=" ")
    print()