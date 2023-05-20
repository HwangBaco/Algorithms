# 백준 2467 : 용액

# 문제
# ---
# 산성 용액, 알칼리성 용액
# 각 용액에 그 용액의 특성을  나타내는 하나의 정수 (1 ~ 1,000,000,000 십억 : 산성) (-1 ~ -1,000,000,000 : 알칼리)
# 같은 양의 두 용액을 혼합한 용액의 특성값은 혼합에 사용된 각 용액의 특성값의 합으로 정의 -> 0에 가장 가까운 용액을 만들려 한다.

# 입력
# ---
# 전체 용액 수 N : 2 이상 100,000 이하 정수
# 배열 : 용액 특성 수

# 투포인터의 핵심은
# 원하는 값을 얻기 위해 가장 효율적으로 움직여라. (완탐으로는 시간이 부족할 때 쓰는 알고리즘이다.)
# 따라서 포인터가 이 문제에서는 양 끝에서 시작함을 떠올릴 수 있어야 한다.

n = int(input())
li = list(map(int, input().split()))
left, right = 0, n-1
minVal = abs(li[left] + li[right])
ans = [li[left], li[right]]

while left != right:
    if minVal > abs(li[left] + li[right]):
        minVal = abs(li[left] + li[right])
        ans = [li[left], li[right]]

    if li[left] + li[right] >= 0:
        right -= 1
    else:
        left += 1

print(*ans)