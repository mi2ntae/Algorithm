# 평범한 배낭

import sys
sys.setrecursionlimit(100110)

N,K = map(int,input().split())

memoization = [-100001 for _ in range(K+1)]
memoization[0] = 0
item = [list(map(int, input().split())) for _ in range(N)]

for it in item:
    for i in range(K):
        if K-i-it[0] < 0:
            continue
        memoization[K-i] = max(
            memoization[K-i],
            memoization[K-i-it[0]] + it[1]
            )

print(max(memoization))


# def pack(n,i):
#     if n < 0:
#         return -1001
#     if memoization[n][i] != -1:
#         return memoization[n][i]
#     if n == 0 or i == 0:
#         return 0

#     memoization[n][i] = max(
#         pack(n-item[i][0], i-1) + item[i][1],
#         pack(n, i-1),
#         pack(n-1, i)
#         )
#     return memoization[n][i]

# print(pack(K,N))