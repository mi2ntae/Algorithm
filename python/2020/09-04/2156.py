# DP 포도주 시식
import sys
sys.setrecursionlimit(1000000)

N = int(input())
podoju = [int(input()) for _ in range(N)]
memoization = [[-1 for _ in range(3)] for _ in range(10001)]

def drink(n, count):
    if n == 0:
        return 0
    if n == 1:
        if count == 0:
            return podoju[0]
        else:
            return -1001
    
    if memoization[n][count] != -1:
        return memoization[n][count]

    if count == 0:
        memoization[n][0] = max(drink(n-2,0), drink(n-2,1), drink(n-2,2)) + podoju[n-1]
    elif count == 1:
        memoization[n][1] = drink(n-1,0) + podoju[n-1]
    elif count == 2:
        memoization[n][2] = drink(n-1,1)
    return memoization[n][count]

print(max(drink(N,0), drink(N,1), drink(N,2)))