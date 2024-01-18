from collections import deque as dq
import sys
input = sys.stdin.readline

for _ in range(int(input())):
    n, m = map(int, input().split())
    arr = dq(map(int, input().split()))
    t_idx = m # target index
    ans = 0
    while arr:
        max_v = max(arr)
        # print(arr) # test
        x = arr.popleft()
        # if cnt == 0 and x가 중요도가 제일 높은 elem이라면, 그 놈을 뽑고, ans += 1, break
        # print(t_idx) # test
        if t_idx == 0 and x == max_v: ans += 1; break
        # elif x가 중요도가 제일 높은 elem이라면 : 그 놈은 뽑고, ans += 1
        elif x == max_v: ans += 1
        # else : 다시 뒤로 붙이고
        else: arr.append(x)


        # if cnt == 0: cnt += n
        if t_idx == 0: t_idx += (len(arr) - 1)
        # else : cnt -= 1
        else: t_idx -= 1
    print(ans)