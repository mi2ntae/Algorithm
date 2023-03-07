# 피보나치2
import sys
sys.setrecursionlimit(10000000)

n = int(input())

memoization = [-1 for _ in range(91)]
memoization[0] = 0
memoization[1] = 1

def pibo(n):
    if memoization[n] != -1:
        return memoization[n]
    memoization[n] = pibo(n-1) + pibo(n-2)
    return memoization[n] 
    
print(pibo(n))