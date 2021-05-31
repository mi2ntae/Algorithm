# 동전 0 메모이제이션

import sys
sys.setrecursionlimit(10000000)

n,k = input().split()
N = int(n)
K = int(k)
coin = [int(input()) for _ in range(N)]

mem = [-1] * 10001

def count(won):
    global coin
    if won == 0:
        return 0
    elif won < 0:
        return 10001

    if mem[won] != -1:
        return mem[won]
    
    minimum = 10001
    for i in range(N):
        minimum = min(minimum, count(won-coin[i])+1)
    mem[won] = minimum
    return minimum

cc = count(K)
if cc >= 10001:
    print("-1")
else:
    print(cc)

