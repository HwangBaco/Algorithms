# 첫 번째 풀이 : 조합 이용
import sys
input = sys.stdin.readline
from itertools import combinations as cb


while True:
    try:
        li = list(input().split())
        if li[0] == '0': break

        k = int(li[0])
        arr = li[1:]
        # print(k, arr)
        # print(type(arr))
        for i in cb(arr, 6):
            print(*i)
        print()
    except Exception:
        print("e")
        break

# 두 번째 풀이 : dfs 이용
import sys
input = sys.stdin.readline

def go(depth, ans):
    if len(ans) == 6:
        print(*ans)
        return
    else:
        for i in range(depth, len(li)):
            if is_promising(i):
                ans.append(li[i])
                go(depth+1, ans)
                ans.pop()
def is_promising(i):
    if len(ans) == 0:
        return True
    elif li[i] > ans[-1]:
        return True
    return False

while True:
    li = list(map(int, input().split()))
    if li[0] == 0: break
    li = li[1:]
    ans = list()

    go(0, ans)
    print()

