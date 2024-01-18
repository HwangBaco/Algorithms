ans = 0
for _ in range(int(input())):
    s = input()
    stack = list()
    # print(10)
    for ch in s:
        # 스택이 비어있을 경우 그 인덱스 값
        if len(stack) == 0: stack.append(ch)
        else:
            if stack[-1] == ch:
                stack.pop()
            else:
                stack.append(ch)
    if len(stack) == 0: ans += 1
print(ans)