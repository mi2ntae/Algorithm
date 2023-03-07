# 토마토2

import sys
from collections import deque

class location():
    def __init__(self, h, y, x):
        self.x = x
        self.y = y
        self.h = h

m,n,h = map(int, sys.stdin.readline().split())
tomato = [[list(map(int, sys.stdin.readline().split())) for _ in range(n)] for _ in range(h)]
days = [[[-1 for _ in range(m)] for _ in range(n)] for _ in range(h)]

q = deque()

for H in range(h):
    for N in range(n):
        for M in range(m):
            if tomato[H][N][M] == 1:
                days[H][N][M] = 0
                q.append(location(H,N,M))

while q:
    cur = q.popleft()

    dx = [0, -1, 1, 0, 0, 0]
    dy = [-1, 0, 0, 1, 0, 0]
    dh = [0, 0, 0, 0, -1, 1]

    for i in range(6):
        mx = cur.x + dx[i]
        my = cur.y + dy[i]
        mh = cur.h + dh[i]

        if mx != -1 and \
            my != -1 and \
            mh != -1 and \
            mx != m and \
            my != n and \
            mh != h and \
            tomato[mh][my][mx] == 0 and \
            days[mh][my][mx] == -1:
            days[mh][my][mx] = days[cur.h][cur.y][cur.x] + 1
            q.append(location(mh,my,mx))

isgood = True
for H in range(h):
    for N in range(n):
        for M in range(m):
            if tomato[H][N][M] != -1 and days[H][N][M] == -1:
                isgood = False
                break
        if not isgood:
            break
    if not isgood:
        break

if not isgood:
    print("-1")
else:
    print(max(max(max(k) for k in l) for l in days))