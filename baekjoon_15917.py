input = __import__('sys').stdin.readline

for i in range(int(input())):
    norm = 0    # 2의 거듭제곱 판별 가능 여부 기준 : 1일 때만 True
    num = bin(int(input()))
    for idx in num:
        if idx == "1":
            norm += 1
    print(1 if norm == 1 else 0)