input = __import__('sys').stdin.readline # time over 때문에 빠른 입력을 사용해야 함.
plug = 0
for i in range(int(input())):
    plug += int(input())
print(plug - i)