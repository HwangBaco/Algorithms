n, m = map(int, input().split()) # n 칸으로 나누어진 스크린, m 칸을 차지하는 바구니
i = 1 # 바구니 현재 위치(왼쪽 끝 기준)
result = 0
for _ in range(int(input())):
    spot = int(input()) # 떨어지는 사과 위치
    if spot > i+m-1: # 바구니가 오른쪽으로 이동해야 하는 경우
        while i+m-1 != spot:
            i += 1
            result += 1
    elif spot < i: # 바구니가 왼쪽으로 이동해야 하는 경우
        while i != spot:
            i -= 1
            result += 1
print(result)