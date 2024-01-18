# camel
# snake
# pascal

n, s = map(str, input().split())

# 전처리 ; 케이싱 다 처리하고 띄어쓰기로 구분
s = s.replace("_", " ")
for ch in s:
    if ch.isupper():
        # idx = s.find(ch)
        low_ch = ch.lower()
        s = s.replace(ch, " "+low_ch)
s = s.replace("  ", " ").strip()

# camelCase
camel_s = list(s.strip())
for ch in camel_s:
    if ch == " ":
        idx = camel_s.index(ch)
        camel_s[idx] = ''
        camel_s[idx+1] = camel_s[idx+1].upper()
print(''.join(camel_s))
# print(str(camel_s).replace(" ", ""))

# snake_case
print(s.replace(" ", "_"))

# Paskal_case
camel_s[0] = camel_s[0].upper()
print(''.join(camel_s))
# print(str(camel_s).replace(camel_s[0], camel_s[0].upper()).replace(" ", ""))