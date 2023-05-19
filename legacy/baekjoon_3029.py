h1, m1, s1 = map(int, input().split(":"))
h2, m2, s2 = map(int, input().split(":"))

start_time = h1 * 3600 + m1 * 60 + s1
event_time = h2 * 3600 + m2 * 60 + s2

if start_time >= event_time: # 적어도 1초를 기다려야 하고, 최대 24시간을 기다려야 하므로 등호를 추가해야 함.
    event_time += 86400

ans = event_time - start_time
h = str(ans // 3600).zfill(2)
m = str((ans % 3600) // 60).zfill(2)
s = str((ans % 3600) % 60).zfill(2)

print(f"{h}:{m}:{s}")