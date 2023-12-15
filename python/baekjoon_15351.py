for _ in range(int(input())):
    s = input()
    ans = 0
    for char in s:
        if char == " ": continue
        n = ord(char) - 64
        ans += n
    print("PERFECT LIFE" if ans == 100 else ans)