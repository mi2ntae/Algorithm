# 앱

import sys
input = sys.stdin.readline

N,M = map(int, input().strip().split())
usedm = list(map(int, input().strip().split()))
cost = list(map(int, input().strip().split()))

k = M+max(usedm)
memoization = [10001 for _ in range(k)]
memoization[0] = 0

for i in range(N):
    for n in range(k-1,0,-1):
        if n-usedm[i] < 0:
            continue
        memoization[n] = min(memoization[n], memoization[n-usedm[i]] + cost[i])

print(min(memoization[M:]))