# 침투

from collections import deque
import sys
input = sys.stdin.readline

M,N = map(int, input().strip().split())
grid = [input().strip() for _ in range(M)]

q = deque()
vst = [[False for _ in range(N)] for _ in range(M)]
ans = "NO"

for i in range(N):
    if grid[0][i] == '0':
        q.append((0,i))
        vst[0][i] = True

while q:
    y,x = q.popleft()
    if y == M-1:
        ans = "YES"
    dx = [0,-1,1,0]
    dy = [-1,0,0,1]

    for i in range(4):
        mx = x + dx[i]
        my = y + dy[i]
        if mx >= 0 and mx < N and \
            my >= 0 and my < M and \
            grid[my][mx] == '0' and \
            not vst[my][mx]:
            q.append((my,mx))
            vst[my][mx] = True

print(ans)