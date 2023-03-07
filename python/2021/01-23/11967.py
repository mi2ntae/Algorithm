# 불켜기

import sys
from collections import deque
input = sys.stdin.readline

N,M = map(int,input().strip().split())

q = deque()
q.append((1,1))
ans = 0

rooms = [[[False,False,[]] for _ in range(N+1)] for _ in range(N+1)]
rooms[1][1] = [True,True,[]]

for _ in range(M):
    x,y,a,b, = map(int, input().strip().split())
    rooms[y][x][2].append((a,b))

while q:
    x,y = q.popleft()
    for a,b in rooms[y][x][2]:
        if rooms[b][a][0] and not rooms[b][a][1]:
            q.append((a,b))
        rooms[b][a][1] = True
    
    dx = [0,-1,1,0]
    dy = [-1,0,0,1]
    for i in range(4):
        mx = x+dx[i]
        my = y+dy[i]
        if mx > 0 and my > 0 and \
            mx <= N and my <= N:
            if rooms[my][mx][1] and not rooms[my][mx][0]:
                q.append((mx,my))
            rooms[my][mx][0] = True

for r in range(1,N+1):
    for c in range(1,N+1):
        if rooms[r][c][1]:
            ans += 1

print(ans)