import sys
input = sys.stdin.readline

"""
관건은 맨 앞자리 숫자가 우선 가장 커야한다는 것.

그리고 남은 숫자 중에서 맨 앞에서부터 차례로 탐색하면서 뒷 숫자가 앞 숫자보다 크면 앞 숫자를 지운다는 것.

그렇다면 뒤에서 % find_length % 길이 이후의 숫자부터 가장 큰 숫자의 인덱스를 찾고, 그 앞은 전부 날림 -> 날린 갯수 만큼 k 빼기
남은 카운트 개수로 뒤 문자 순회하면서 앞 자리보다 뒷 자리가 큰 경우 제거함.

###

1. 앞 자리 수가 가장 큰 수 일 것.
2. 그 바로 뒷 자리부터 반복.

"""

n, k = map(int, input().split())
length = n - k
li = [i for i in input().strip()]

stack = []
ans = []
for i in range(len(li)):
    while k and stack and li[stack[-1]] < li[i]:
        # ans.append(li[i])
        stack.pop()
        k -= 1
    stack.append(i)

for i in stack:
    ans.append(li[i])
while len(ans) > length:
    ans.pop()
print(''.join(ans))