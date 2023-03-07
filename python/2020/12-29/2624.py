# 동전 바꿔주기

import sys
input = sys.stdin.readline

T = int(input().strip())
K = int(input().strip())

memoization = [0 for _ in range(T+1)]

coin = []
for _ in range(K):
    P,N = map(int, input().strip().split())
    coin.append((P,N))
coin.sort(reverse=True)

memoization[0] = 1

for c in range(K):
    for n in range(T,-1,-1):
        for count in range(1,coin[c][1]+1):
            if n - (coin[c][0] * count) < 0:
                break
            memoization[n] += memoization[n-coin[c][0]*count]

print(memoization[T])