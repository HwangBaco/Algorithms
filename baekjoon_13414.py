# 수강 가능 인원 K : 1 <= K <= 100,000
# 대기 목록 길이 L : 1< = L <= 500,000
import sys
input = sys.stdin.readline
from collections import defaultdict as dd


K, L = map(int, input().split())
dic = dd(int)
cnt = 0

for i in range(L):
    s = input().strip()
    dic[s] = i
swap_dic = {value : key for key, value in dic.items()}
li = sorted(swap_dic.keys(), key=lambda x : x)
for i in li:
    if cnt == K: break
    print(swap_dic[i])
    cnt += 1