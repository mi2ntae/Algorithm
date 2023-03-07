# 정수 삼각형

import sys
sys.setrecursionlimit(10000000)
input = sys.stdin.readline

n = int(input())
triangle = [list(map(int, input().split())) for _ in range(n)]
memoization = [[0 for _ in range(n+1)] for _ in range(n)]

def findTri(col,row):
    if col < 0 or row < 0:
        return 0
    if memoization[col][row] != 0:
        return memoization[col][row]

    if row == 0:
        memoization[col][row] = findTri(col-1,row)+triangle[col][row]
    elif row == col:
        memoization[col][row] = findTri(col-1,row-1)+triangle[col][row]
    else:
        memoization[col][row] = max(findTri(col-1,row), findTri(col-1,row-1))+triangle[col][row]
    
    return memoization[col][row]

for i in range(n):
    findTri(n-1,i)
    
print(max(memoization[n-1]))