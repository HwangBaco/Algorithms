for i in range(int(input())):
    hobit, g_human, elf, dwarf, eagle, g_magician = map(int, input().split())
    oak, s_human, wolf, goblin, hi, troll, s_magician = map(int, input().split())
    g_score = hobit*1 + g_human*2 + elf*3 + dwarf*3 + eagle*4 + g_magician*10
    s_score = oak*1 + s_human*2 + wolf*2 + goblin*2 + hi*3 + troll*5 + s_magician*10
    if s_score > g_score:
        print(f"Battle {i+1}: Evil eradicates all trace of Good")
    elif s_score < g_score:
        print(f"Battle {i+1}: Good triumphs over Evil")
    else:
        print(f"Battle {i+1}: No victor on this battle field")