for i in range(int(input())):
    # A: 필요한 블래스터 라이플의 개수
    # B: 필요한 시각 센서의 개수
    # C: 필요한 청각 센서의 개수
    # D: 필요한 팔의 수
    # E: 필요한 다리의 수
    A, B, C, D, E = map(int, input().split())
    print("${:.2f}".format(A * 350.34 + B * 230.90 + C * 190.55 + D * 125.30 + E * 180.90))