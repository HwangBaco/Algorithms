kda = input()

kda = kda.split(sep="/")

# K + A < D 이거나, D = 0이면 hasu, 아니면 gosu

k = int(kda[0])
d = int(kda[1])
a = int(kda[2])

if k + a < d or d == 0:
    print("hasu")
else :
    print("gosu")
    