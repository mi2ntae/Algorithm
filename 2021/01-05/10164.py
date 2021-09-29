# 격자상의 경로

N,M,K = map(int, input().split())

def grid(sx,sy,dx,dy):
    x = dx-sx
    y = dy-sy
    memoization = [[1 for _ in range(x+1)] for _ in range(y+1)]
    for r in range(y+1):
        for c in range(x+1):
            if r-1 < 0 or c-1 < 0:
                continue
            memoization[r][c] = memoization[r-1][c] + memoization[r][c-1]

    return memoization[y][x]

if K == 0:
    print(grid(0,0,M-1,N-1))
else:
    oy = K//M-1 if K%M == 0 else K//M
    ox = M-1 if K%M == 0 else K%M-1
    print(grid(0,0,ox,oy)*grid(ox,oy,M-1,N-1))