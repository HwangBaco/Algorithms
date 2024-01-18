stack = list()
ans = list()
max_val = 0
is_impossible = False

for r in range(int(input())):
    n = int(input())
    if max_val < n:
        for i in range(max_val+1, n+1):
            stack.append(i)
            ans.append('+')

        if len(stack) == 0: is_impossible = True
        else:
            stack.pop()
            ans.append('-')
        max_val = n

    elif n in stack:
        while 1:
            print(stack[-1])
            if stack[-1] == n-1: break
            stack.pop()
            ans.append('-')

    print(ans) # test
    print(stack) # test
if is_impossible: print("NO")
else: print(ans)