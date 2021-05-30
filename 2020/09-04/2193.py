# 이친수 재귀
import sys
sys.setrecursionlimit(10000000)

N = int(input())
memoization = [-1 for _ in range(91)]
memoization[1] = 1
memoization[2] = 1

def pn(n):
    if memoization[n] != -1:
        return memoization[n]

    memoization[n] = pn(n-1) + pn(n-2)
    return memoization[n]

print(pn(N))