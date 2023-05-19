import sys
input = sys.stdin.readline

## 첫 번째 시도
# def is_prime(n):
#     for i in range(2,n):
#         if n % i == 0:
#             return False
#     return True
#
# trash = input()
# li = list(map(int, input().split()))
# ans = 0
# for i in li:
#     if i == 1: pass
#     elif is_prime(i):
#         ans += 1
# print(ans)

# 두 번째 시도

def is_prime_fast(n):
    if n == 1: return False
    for i in range(2, round(n**0.5)+1):
        if n % i == 0:
            return False
    return True


trash = input()
li = list(map(int, input().split()))
ans = 0
for i in li:
    if is_prime_fast(i):
        ans += 1
print(ans)
