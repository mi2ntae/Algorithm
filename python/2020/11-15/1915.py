# 가장 큰 정사각형
import sys
input = sys.stdin.readline

n,m = map(int, input().strip().split())
grid = [[0 for _ in range(m)] for _ in range(n)]

for r in range(n):
    a = input().strip()
    for c in range(m):
        grid[r][c] = int(a[c])

ans = 0

for r in range(n):
    for c in range(m):
        if grid[r][c] == 0:
            continue
        
        if ans == 0:
            ans = 1

        if c-1 >= 0 and r-1 >= 0:
            if grid[r-1][c] != 0 and \
                grid[r][c-1] != 0 and \
                grid[r-1][c-1] != 0:
                grid[r][c] = min(grid[r-1][c], grid[r][c-1], grid[r-1][c-1])+1
                ans = max(ans, grid[r][c])

print(ans**2)