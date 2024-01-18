import sys
input = sys.stdin.readline
n = int(input())
members = []

for _ in range(n):
    age, name = input().split()
    age = int(age)
    members.append((age, name))

# 나이를 기준으로 정렬하고, 나이가 같다면 입력 순서대로 정렬합니다.
members.sort(key=lambda x: x[0])

for member in members:
    print(*member)