# 색종이

import sys
input = sys.stdin.readline

N = int(input().strip())
grid = [[None for _ in range(101)] for _ in range(101)]
ans = [0 for _ in range(N)]

for n in range(N):
    x,y,w,h = map(int,input().strip().split())
    for i in range(w):
        for j in range(h):
            grid[y+j][x+i] = n

for n in range(N):
    for i in range(101):
        for j in range(101):
            if grid[i][j] == n:
                ans[n] += 1

for i in range(len(ans)):
    print(ans[i])