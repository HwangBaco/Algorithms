# 문자열이 주어짐
# 스택과 2 종류의 cnt로 구성
# 스택은 값을 계산하기 위함
# 2종류의 cnt는 괄호 식이 올바른지 검사

#2504_괄호의 값_구현 자료구조 스택 재귀_silver1
bracket = input()
length = len(bracket)
stack = []
tmp = 1
res = 0

for i in range(length):
    b = bracket[i]
    if b == '(':
        tmp *= 2
        stack.append(b)
    elif b == '[':
        tmp *= 3
        stack.append(b)

    elif b == ')':
        if not stack or stack[-1] == '[':
            res = 0
            break
        if bracket[i-1] == '(':
            res += tmp
        tmp //= 2
        stack.pop()
    else:
        if not stack or stack[-1] == '(':
            res = 0
            break
    # [()]의 경우 ] 직전 문자가 )이므로 더하지 않고 넘어감
    # 단, 이 경우는 오류는 아님 >> 지금까지 계산한거 한번만 해주면 되기 때문에...
        if bracket[i-1] == '[':
            res += tmp
        tmp //= 3
        stack.pop()

if stack:
    res = 0
print(res)