input = __import__('sys').stdin.readline
li = []
for _ in range(int(input())):
    n = int(input())
    li.append(n)
li.sort(reverse=True)
print(' '.join(map(str, li)))