scenario = 1
result = ""
o, w = 0, 0 # o: 적정 체중 , w: 실제 체중
is_dead = 0

while True:
    a, b = map(str, input().split())
    if a == '0' and  b == '0':
        break
    elif a == '#' and b == '0':
        if is_dead == 1:
            result = "RIP"
        else:
            if w > o/2 and w < 2*o:
                result = ":-)"
            else:
                result = ":-("
        print(f"{scenario} {result}")
        scenario += 1
        is_dead = 0
    elif a == "E":
        w -= int(b)
        if w <= 0:
            is_dead = 1
    elif a == "F":
        w += int(b)
    else:
        o, w = int(a), int(b)