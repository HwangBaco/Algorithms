while 1:
    s = input()
    if s == '.': break
    stack = list()
    is_index_error = True
    for i in s:
        if i == '(' or i == '[':
            stack.append(i)
        elif i == ')':
            if not stack or stack[-1] == '[':
                is_index_error = False
                break
            elif stack[-1] == '(':
                stack.pop()
        elif i == ']':
            if not stack or stack[-1] == '(':
                is_index_error = False
                break
            elif stack[-1] == '[':
                stack.pop()
    if is_index_error == True and not stack:
        print('yes')
    else:
        print('no')