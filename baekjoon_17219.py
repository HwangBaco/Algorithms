input = __import__('sys').stdin.readline

N, M = map(int, input().split()) # N : 저장된 사이트 수, M : 알아내려는 사이트 수
site = dict() # 사이트 아이디(key)와 비밀번호(value) 저장하는 딕셔너리
for _ in range(N):
    id, pw = map(str, input().split())
    site[id] = pw
    # print(site[id])
for _ in range(M):
    s = input().strip()
    print(site[s])