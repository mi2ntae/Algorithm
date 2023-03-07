# 계단오르기 (재귀)
import sys
sys.setrecursionlimit(10000000)

N = int(input())
scores = [int(input()) for _ in range(N)]
memoization = [[-1 for _ in range(3)] for _ in range(301)]


def up(n,adj):
    if n == 0:
        return 0
    if n == 1:
        if adj == 1:
            return scores[0]
        else:
            return -3000001

    if memoization[n][adj] != -1:
        return memoization[n][adj]

    if adj == 1:
        memoization[n][adj] = max(up(n-2, 1), up(n-2, 2)) + scores[n-1]
    if adj == 2:
        memoization[n][adj] = up(n-1, 1) + scores[n-1]

    return memoization[n][adj]
    
print(max(up(N, 1), up(N, 2)))