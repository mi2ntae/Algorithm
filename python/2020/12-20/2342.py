# Dance Dance Revolution

import sys
input = sys.stdin.readline

mov = [
    [1, 2, 2, 2, 2],
    [2, 1, 3, 4, 3],
    [2, 3, 1, 3, 4],
    [2, 4, 3, 1, 3],
    [2, 3, 4, 3, 1],
]

fp = list(map(int, input().strip().split()))
k = len(fp) - 1

memoization = [[[0x3f3f3f3f for _ in range(k + 1)] for _ in range(5)] for _ in range(5)]
memoization[0][0][0] = 0

for step in range(1, k+1):
    c = fp[step-1]
    for l in range(5):
        for r in range(5):
            memoization[l][c][step] = min(memoization[l][c][step], memoization[l][r][step-1] + mov[r][c])

    for r in range(5):
        for l in range(5):
            memoization[c][r][step] = min(memoization[c][r][step], memoization[l][r][step-1] + mov[l][c])

ans = 0x3f3f3f3f
for i in range(0,5):
    ans = min(ans, memoization[fp[k-1]][i][k])
    ans = min(ans, memoization[i][fp[k-1]][k])
    
print(ans)