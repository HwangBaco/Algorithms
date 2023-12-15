import sys
input = sys.stdin.readline


li = list(input().rstrip())
li.sort(reverse=True)
print(''.join(li))
