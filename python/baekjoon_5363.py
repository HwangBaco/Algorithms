for i in range(int(input())):
    li = list(map(str, input().split()))
    print(' '.join(li[2::] + li[0:2]))