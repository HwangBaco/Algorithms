for _ in range(int(input())):
    s = input()
    g_num = s.count('g')
    g_num += s.count('G')
    b_num = s.count('b')
    b_num += s.count('B')
    if g_num > b_num:
        print(f"{s} is GOOD")
    elif g_num < b_num:
        print(f"{s} is A BADDY")
    else:
        print(f"{s} is NEUTRAL")