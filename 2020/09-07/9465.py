# 스티커 bottom up

# f(x,y) -> x,y가 가장 최근에 뗀 것. 왼쪽부터 스티커를 선택했을 때에 최대값

# f(x,y) = max(f(x+1, y+1), f(x+2,y+1))
# import sys
# sys.setrecursionlimit(1000000)

# T = int(input())

# for i in range(T):
#     N = int(input())
#     score = [[0 for _ in range(N)] for _ in range(2)]
    
#     x = input().split()
#     y = input().split()
#     for i in range(N):
#         score[0][i] = int(x[i])
#         score[1][i] = int(y[i])

#     memoization = [[-1 for _ in range(N)] for _ in range(2)] 
    
#     for x in range(N):
#         for y in range(2):
#             m = 0
#             n = 0
#             if x-1 >= 0:
#                 m = memoization[1-y][x-1]
#             if x-2 >= 0:
#                 n = memoization[1-y][x-2]
#             memoization[y][x] = max(m, n) + score[y][x]

#     print(max(memoization[0][N-1], memoization[1][N-1]))

import sys
sys.setrecursionlimit(1000000)

T = int(input())

def stick(y, x):
        if x >= n:
            return 0
        if memoization[y][x] != -1:
            return memoization[y][x]
        
        if y == 0:
            memoization[y][x] = max(stick(y+1,x+1), stick(y+1,x+2)) + score[y][x]
        else:
            memoization[y][x] = max(stick(y-1,x+1), stick(y-1,x+2)) + score[y][x]

        return memoization[y][x]

for i in range(T):
    n = int(input())
    score = [[0 for _ in range(n)] for _ in range(2)]
    
    x = input().split()
    y = input().split()
    for i in range(n):
        score[0][i] = int(x[i])
        score[1][i] = int(y[i])

    memoization = [[-1 for _ in range(n)] for _ in range(2)] 
    
    print(max(stick(0,0), stick(1,0)))