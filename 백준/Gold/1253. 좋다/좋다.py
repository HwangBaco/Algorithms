import sys
input = sys.stdin.readline

if __name__ == '__main__': 
    n = int(input())
    li = sorted(list(map(int, input().split())))
    ans = 0
    for i in range(n):
        left, right = 0, len(li)-2
        temp = li[:i] + li[i+1:]
        while left < right:
            v = temp[left] + temp[right]
            if v == li[i]:
                ans += 1
                break
            elif v < li[i]:
                left += 1
            else :
                right -= 1
    
    print(ans)