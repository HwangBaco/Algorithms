import sys
input = sys.stdin.readline

def is_pseudo(string, left, right):
    while True:
        if left > right: break
        if string[left] == string[right]: left += 1; right -= 1
        else:
            return False
    return True
def is_palindrom(string):
    if string == string[::-1]:
        return 0
    else:
        left = 0
        right = len(string) - 1
        while True:
            if left > right: break
            if string[left] != string[right]:
                l_flag = is_pseudo(string,left+1,right)
                r_flag = is_pseudo(string,left,right-1)
                if l_flag or r_flag: return 1
                else: return 2
            else:
                left += 1
                right -= 1

for _ in range(int(input())):
    print(is_palindrom(input().rstrip()))