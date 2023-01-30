n, k = map(int, input().split())

# n 자리 숫자가 주어지고
# k 개의 숫자를 그 리스트에서 지운다.
# 그 결과가 가장 큰 수여야 한다.

# n 자리 숫자가 들어있는 리스트에서
# 최솟값을 제거하는 동작을
# k번 반복한다.

# 그리고 남은 리스트를 join으로 출력

li = list(input())
for _ in range(k):
    li.pop(li.index(min(li)))
print(''.join(li))