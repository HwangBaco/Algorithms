s = input()
is_index_error = True

for i in range(len(s)//2):
    if s[i] != s[-1-i]:
        is_index_error = False
print(str(is_index_error).lower())