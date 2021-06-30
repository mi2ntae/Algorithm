# 2*n 타일링

import sys
sys.setrecursionlimit(10000000)

n = int(input())
memoization = [0 for _ in range(n+1)]
memoization[1] = 1
if n >= 2:
    memoization[2] = 2

def fillRect(row):
    if row < 1:
        return -1
    if memoization[row] != 0:
        return memoization[row]

    memoization[row] = fillRect(row-2)+fillRect(row-1)
    return memoization[row]

print(fillRect(n)%10007)

