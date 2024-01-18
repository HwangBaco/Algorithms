A_attack, A_life = map(int, input().split())
B_attack, B_life = map(int, input().split())

while A_life > 0 and B_life > 0:
    A_life = A_life - B_attack
    B_life = B_life - A_attack

if A_life <= 0 and B_life <= 0:
    print("DRAW")
elif A_life > 0 and B_life <= 0:
    print("PLAYER A")
elif A_life <= 0 and B_life > 0:
    print("PLAYER B")
