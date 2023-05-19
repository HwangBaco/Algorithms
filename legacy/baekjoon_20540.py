input = __import__('sys').stdin.readline

mbti = input()
for idx in mbti:
    if idx == "E":
        print("I", end="")
    elif idx == "I":
        print("E", end="")
    elif idx == "N":
        print("S", end="")
    elif idx == "S":
        print("N", end="")
    elif idx == "T":
        print("F", end="")
    elif idx == "F":
        print("T", end="")
    elif idx == "J":
        print("P", end="")
    elif idx == "P":
        print("J", end="")
