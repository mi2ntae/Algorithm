# 격자상의 경로

import sys
sys.setrecursionlimit(500)

N,M,K = map(int, input().split())

grid = []
memoization =  [[-1 for _ in range(M)] for _ in range(N)]
if K%M == 0:
    ox = M-1
    oy = K//M-1
else:
    ox = K%M-1
    oy = K//M

for i in range(M):
    memoization[0][i] = 1
for i in range(N):
    memoization[i][0] = 1

for i in range(N):
    grid.append(list(range(5*i+1,5*i+6)))

def dfs(r,c):
    if memoization[r][c] != -1:
        return memoization[r][c]
    memoization[r][c] = dfs(r-1,c) + dfs(r,c-1)

    return memoization[r][c]

if K == 0:
    print(dfs(N-1,M-1))
else:
    print(dfs(oy,ox) * dfs(N-oy-1,M-ox-1))
