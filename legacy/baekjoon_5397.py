import sys
input = sys.stdin.readline

for _ in range(int(input())):
    s = input()
    ans = list()
    cursor = 0
    for char in s:
        if char == '<':
            cursor -= 1 if cursor > 0 else cursor
            # print(cursor)
        elif char == '>':
            cursor += 1 if len(ans) - 1 > cursor else cursor
            # print(cursor)
        elif char == '-':
            if cursor >= len(ans):
                ans.pop()
            else:
                ans.pop(cursor)
        else:
            ans.insert(cursor, char)
            cursor += 1 if len(ans) - 1 > cursor else cursor
    print(''.join(ans))