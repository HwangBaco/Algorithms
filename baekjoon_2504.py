# 문자열이 주어짐
# 스택과 2 종류의 cnt로 구성
# 스택은 값을 계산하기 위함
# 2종류의 cnt는 괄호 식이 올바른지 검사

stk = list()
p_cnt, b_cnt = 0, 0 # parentheses count , brackets count

s = input()
for i in s:
    if i == '(':
        stk.append(i)
        p_cnt += 1
    elif i == '[':
        stk.append(i)
        b_cnt += 1
    elif i == ')': # 이 때 stk을 마구 뽑아서 그 값을 계산해야 함
        try:
            stk.pop(stk.index('('))
            p_cnt -= 1
        except IndexError:
            print(0)
            break
    elif i == ']': # 이 때 stk을 마구 뽑아서 그 값을 계산해야 함
        try:
            stk.pop(stk.index('['))
            b_cnt -= 1
        except IndexError:
            print(0)
            break