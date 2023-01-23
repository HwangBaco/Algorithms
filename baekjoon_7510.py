for i in range(int(input())):
    triangle = list(map(int, input().split()))
    triangle.sort()
    print(f"Scenario #{i+1}:")
    if triangle[0] * triangle[0] + triangle[1] * triangle[1] == triangle[2] * triangle[2]:
        print("yes")
        # print()
    else:
        print("no")
        # print()