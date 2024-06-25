import sys
input = sys.stdin.readline

N = int(input())
li = sorted(list(map(int, input().split())))

left = 0
right = len(li)-1
min = 10**18
ans_l = 0
ans_r = len(li)
has_answer = False

while left < right:
    if li[left] + li[right] == 0:
        print(li[left], li[right])
        has_answer = True
        break
    elif li[left] + li[right] > 0:
        if min > abs(li[left] + li[right]):
            min = abs(li[left] + li[right])
            ans_l = left
            ans_r = right
        right -= 1
    else :
        if min > abs(li[left] + li[right]):
            min = abs(li[left] + li[right])
            ans_l = left
            ans_r = right
        left += 1

if not has_answer:
    print(li[ans_l], li[ans_r])