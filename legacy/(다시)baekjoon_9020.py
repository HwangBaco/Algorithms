import sys
input = sys.stdin.readline

def is_prime(x):
    for i in range(2,x):
        if x % i == 0: return False
    return True

# 소수 배열 먼저 생성
prime_nums = []
for i in range(2, 10000):
    if is_prime(i): prime_nums.append(i)

for _ in range(int(input())):
    n = int(input())


# for _ in range(int(input())):
#     n = int(input())
#     a, b = 1, n
#     for i in range(2, n):
#         if is_prime(i) and is_prime(n-i):
#             if abs(b-a) > abs(n-i-i):
#                 a, b = i, n-i
#     print(a, b)

