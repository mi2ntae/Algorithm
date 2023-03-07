# 쿼드트리

import sys
sys.setrecursionlimit(100000000)
input = sys.stdin.readline

N = int(input())

field = [input() for _ in range(N)]

def quadTree(N, r, c):
    if N == 1:
        return field[r][c]
    
    result = ""
    result += quadTree(N//2, r, c)
    result += quadTree(N//2, r, c+N//2)
    result += quadTree(N//2, r+N//2, c)
    result += quadTree(N//2, r+N//2, c+N//2)

    if result == "0000":
        result = "0"
    elif result == "1111":
        result = "1"
    else:
        result = "(" + result + ")"
    return result

print(quadTree(N, 0, 0))