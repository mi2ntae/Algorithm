# 토마토 BFS

import sys
from collections import deque

class Position():
    def __init__(self,n,m):
        self.n = n
        self.m = m

M,N = map(int, sys.stdin.readline().split())

tomato = [list(map(int, sys.stdin.readline().split())) for _ in range(N)]
days = [[-1 for _ in range(M)] for _ in range(N)]

q = deque()

for n in range(N):
    for m in range(M):
        if tomato[n][m] == 1:
            days[n][m] = 0
            q.append(Position(n,m))

while q:
    cur = q.popleft()
    dx = [0, -1, 1, 0]
    dy = [-1, 0, 0, 1]
    for a in range(4):
        mx = cur.m + dx[a]
        my = cur.n + dy[a]
        if mx != -1 and my != -1 and mx != M and my != N \
            and days[my][mx] == -1 and tomato[my][mx] == 0:
            days[my][mx] = days[cur.n][cur.m] + 1
            q.append(Position(my,mx))

isokay = True
for n in range(N):
    for m in range(M):
        if tomato[n][m] != -1 and days[n][m] == -1:
            isokay = False
            break
    if not isokay:
        break

if not isokay:
    print("-1")
else:
    print(max([max(l) for l in days]))