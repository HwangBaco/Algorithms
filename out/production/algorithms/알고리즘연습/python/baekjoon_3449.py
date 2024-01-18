for i in range(int(input())):
    s1 = input()
    s2 = input()
    hamming_distance = 0
    for idx in range(len(s1)):
        if s1[idx] != s2[idx]: hamming_distance += 1
    print(f"Hamming distance is {hamming_distance}.")