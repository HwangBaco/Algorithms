def solution(s):
    result = []
    
    if len(s) == 1:
        return 1
    
    # 문자열 토큰 크기
    for i in range(1, len(s)+1):
        res = ''
        cnt = 1
        compare = s[:i]
        
        for j in range(i, len(s) + i, i):
            if s[j:j+i] == compare:
                cnt += 1
            else:
                if cnt == 1:
                    res += compare
                else:
                    res += str(cnt) + compare
                compare = s[j:j+i]
                cnt = 1
        result.append(len(res))
    return min(result)