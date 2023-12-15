s = input()
mid_p = len(s)//2
a = list(map(int,(s[:mid_p])))
b = list(map(int, (s[mid_p:])))
# print(a, b)
res_a = sum(a)
res_b = sum(b)
if res_a == res_b: print("LUCKY")
else: print("READY")