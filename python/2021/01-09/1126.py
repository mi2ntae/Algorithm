# 같은 탑

import sys
input = sys.stdin.readline

N = int(input().strip())
block = [0]+list(map(int, input().strip().split()))

memoization = [[-1 for _ in range(500001)] for _ in range(N+1)]
memoization[0][0] = 0

for n in range(N):
    for h in range(500001):
        if memoization[n][h] == -1:
            continue
        memoization[n+1][h] = max(
            memoization[n][h],
            memoization[n+1][h],
        )
        memoization[n+1][h+block[n+1]] = max(
            memoization[n+1][h+block[n+1]],
            memoization[n][h]
        )
        if h < block[n+1]:
            memoization[n+1][block[n+1]-h] = max(
                memoization[n+1][block[n+1]-h],
                memoization[n][h]+h
            )
        else:
            memoization[n+1][h-block[n+1]] = max(
                memoization[n+1][h-block[n+1]],
                memoization[n][h]+block[n+1]
            )

print(-1 if memoization[N][0] == 0 else memoization[N][0])