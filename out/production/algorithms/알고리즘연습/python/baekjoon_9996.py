n = int(input()) # number of sentences
pattern = input()
asterisk_index = pattern.find('*')
for _ in range(n):
    sentence = input()

    # 두 가지 반례를 걸러내기 위한 로직:
    # 1. pattern: a*a 일 때, sentence : a -> 답 : NE
    # 2. pattern: ab*bd 일 때, sentence : abd -> 답 : NE
    if len(sentence) < (len(pattern) - 1):
        print("NE")
        continue

    if sentence[:len(pattern[:asterisk_index])] == pattern[:asterisk_index] and sentence[-len(pattern[asterisk_index+1:]):] == pattern[asterisk_index+1:]:
        print("DA")
    else:
        print("NE")
