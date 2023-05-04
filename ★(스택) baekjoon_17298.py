"""
* 문제 해석:
오큰수란, 해당 숫자의 오른쪽 수 중에서 해당 숫자보다 큰 수 중 가장 왼쪽에 있는 수를 의미

시간 제한 : 1초 + 수열의 크기 1백만 이하, 수열의 원소 1백만 이하

리스트의 모든 인덱스별 오큰수 출력
"""
"""
* 문제 접근:

- 첫 번째 시도 (당연하게도 시간초과)
0. ans = []
1. 리스트를 입력받는다.
2. 입력받은 리스트를 순회한다.
    1. 리스트 숫자 하나 받고
    2. 맨 앞의 숫자를 리스트에서 pop()한 뒤 cmp에 저장해둠
    3. res = [] 하나 선언해두고
    4. 남은 리스트 순회한다.
        1. 남은 리스트 elem과 cmp 비교
        2. if elem > cmp : res.append(elem)
    5. if len(res): ans.append(res[0])
    6. else: ans.append(-1)
3. print(*ans)

- 두 번째 시도
1. 리스트(덱) 순회
    1. cmp = dq.popleft()
    2. dd[cmp] = 0
    3. 
"""

# from collections import deque
# import sys
# input = sys.stdin.readline
#
# ans = []
# t = int(input())
# dq = deque((map(int, input().split())))
# for i in range(t):
#     cmp = dq.popleft()
#     res = []
#     for elem in dq:
#         if elem > cmp: res.append(elem)
#     if len(res): ans.append(res[0])
#     else: ans.append(-1)
# print(*ans)

N = int(input())
nums = list(map(int, input().split()))

stack = []
answer = [-1]*N

for i in range(N):
    # 스택이 비어있지 않고 / nums의 인덱스 스택[-1] < nums의 인덱스 i
    while stack and nums[stack[-1]] < nums[i]:  #stack이 비어있지않고 스택[-1]
        print(stack)
        answer[stack.pop()] = nums[i]
    stack.append(i)
print(*answer)