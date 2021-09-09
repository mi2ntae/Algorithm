# 경찰차

import sys
input = sys.stdin.readline

N = int(input())
W = int(input())
spots = [(1, 1), (N, N)] + [tuple(map(int, input().strip().split())) for _ in range(W)]

memoization = [[-1 for _ in range(W+2)] for _ in range(W+2)]
memoization[0][1] = 0
footprint = [[-1 for _ in range(W+2)] for _ in range(W+2)]

def dp(u, i):
    if memoization[u][i] != -1:
        return memoization[u][i]

    if i <= u:
        memoization[u][i] = 0x3f3f3f3f
        return memoization[u][i]

    r, c = spots[i]
    pr, pc = spots[i-1]

    memoization[u][i] = dp(u, i-1) + abs(r - pr) + abs(c - pc)
    
    if i-1 == u:
        for j in range(0, i-1):
            xr, xc = spots[j]
            cost = dp(j, i-1) + abs(xr - r) + abs(xc - c)
            if cost < memoization[u][i]:
                memoization[u][i] = cost
                footprint[u][i] = j

    return memoization[u][i]

ans = 0x3f3f3f3f
bestu = 0
for j in range(W+1):
    if dp(j, W+1) < ans:
        ans = dp(j, W+1)
        bestu = j

move = []

u = bestu
i = W+1
while not (u == 0 and i == 1):
    if footprint[u][i] == -1:
        move.append(2)
        i = i-1
    else:
        move.append(1)
        u = footprint[u][i]
        i = i-1
        
move.reverse()
s, b = 1, 2
for i in range(len(move)):
    if move[i] == 1:
        move[i] = s
        s, b = b, s
    else:
        move[i] = b

print(ans)
print(*move, sep="\n")