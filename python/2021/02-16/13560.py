# 축구 게임

import sys
input = sys.stdin.readline

N = int(input().strip())
report = list(map(int, input().strip().split()))

report.sort(reverse=True)

wl = []
for i in range(N):
    wl.append([report[i], N-1-report[i]])

for i in range(N):
    count = report[i]
    for j in range(N):
        if count == 0:
            break
        if N-1-j == i:
            continue
        if wl[N-1-j][1] > 0:
            wl[N-1-j][1] -= 1
            wl[i][0] -= 1
            count -= 1

ans = 1

for i in range(N):
    for j in range(2):
        if wl[i][j] != 0:
            ans = -1

print(ans)