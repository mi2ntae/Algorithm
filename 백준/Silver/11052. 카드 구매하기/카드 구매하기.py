# 카드 구매하기

import sys
input = sys.stdin.readline

N = int(input().strip())
cards = list(map(int, input().strip().split()))

memoization = [0 for _ in range(N+1)]
for i,v in enumerate(cards):
    k = i+1
    for j in range(N+1):
        if k+j > N:
            break
        memoization[k+j] = max(memoization[k+j], memoization[j]+v)
print(memoization[N])