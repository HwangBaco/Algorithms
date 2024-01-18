while True:
    s = input()
    # loop-break when END
    if s == "END":
        break
    print(s[::-1])