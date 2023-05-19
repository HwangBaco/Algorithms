for i in range(int(input())):
    p1_score = 0
    p2_score = 0
    for j in range(int(input())):
        player1, player2 = map(str, input().split())
        if player1 == "R":
            if player2 == "R":
                pass
            elif player2 == "S":
                p1_score += 1
            elif player2 == "P":
                p2_score += 1
        elif player1 == "S":
            if player2 == "R":
                p2_score += 1
            elif player2 == "S":
                pass
            elif player2 == "P":
                p1_score += 1
        elif player1 == "P":
            if player2 == "R":
                p1_score += 1
            elif player2 == "S":
                p2_score += 1
            elif player2 == "P":
                pass
    if p1_score > p2_score:
        print("Player 1")
    elif p1_score < p2_score:
        print("Player 2")
    else:
        print("TIE")