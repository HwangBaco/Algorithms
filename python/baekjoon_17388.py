li = list(map(int, input().split()))
s, k, h = li
if sum(li) >= 100:
    print("OK")
else:
    if min(li) == s:
        print("Soongsil")
    elif min(li) == k:
        print("Korea")
    else:
        print("Hanyang")
