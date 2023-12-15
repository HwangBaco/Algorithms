n = int(input()) # 종이에 적은 수의 개수 2 <= N <= 100
li = list()
ans = list() # 나머지가 모두 같게 되는 M을 담아라.
for i in range(n):
    li.append(int(input())) # 숫자 1 ~ 1,000,000,000(십억)

# business logic here
m_num = min(li)



print(*sorted(ans))