block = list(map(int, input().split()))
while True:
    for idx in range(0, len(block)-1):
        if block[idx] > block[idx+1]:
            temp = block[idx]
            block[idx] = block[idx+1]
            block[idx+1] = temp
            print(' '.join(map(str, block)))
        else:
            pass
    if block == sorted(block):
        break
