time_left = 30
chapter_fin = 0
for i in range(int(input())):
    # print(f"{i+1}번째 문제 공부를 시작합니다. 남은 시간은 {time_left}분 입니다.") # test
    time_needed = int(input()) # 챕터당 공부하는 데 걸리는 시간
    if (time_needed/2) <= time_left:
        chapter_fin += 1
        # print(f"{i+1}번째 문제는 절반 이상 공부했습니다.") # test
    time_left = time_left - time_needed
    if time_left <= 0:
        # print(f"남은 시간이 {time_left} 이므로 시간을 돌립니다.") # test
        time_left = 30
print(chapter_fin)