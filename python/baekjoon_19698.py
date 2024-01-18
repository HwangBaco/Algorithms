N, W, H, L = map(int, input().split())

# print(f"소들의 수 : {N}")
# print(f"헛간의 크기 : {W * H}")
# print(f"소들에게 배정되는 공간 : {L * L}")
#
# print(f"헛간에 최대 몇마리까지 입주할 수 있나 : {(W // L) * (H // L)}")

result = (W // L) * (H // L)

if result > N:
    print(N)
else:
    print(result)