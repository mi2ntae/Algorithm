# 재귀 하노이탑
import sys
sys.setrecursionlimit(100000000)

def hanoi(N, src, mid, dst):
    if N == 0:
        return
    hanoi(N-1, src, dst, mid)
    print(src, dst)
    hanoi(N-1, mid, src, dst)

hanoi(3,1,2,3)

