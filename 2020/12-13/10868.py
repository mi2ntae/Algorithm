# 최솟값

import sys
input = sys.stdin.readline

def findMin(a,b,cur,l,r):
    if a <= l and r <= b:
        return seg[cur]
    if a >= r or b <= l:
        return 1000000001
    mid = (l+r)//2
    return min(findMin(a,b,cur*2,l,mid), findMin(a,b,cur*2+1,mid,r))
    
N,M = map(int, input().strip().split())

segsize = 2
while segsize < N:
    segsize *= 2

seg = [1000000001] * segsize * 2
for i in range(N):
    k = int(input())
    seg[segsize+i] = k

for i in range(segsize-1,0,-1):
    seg[i] = min(seg[i*2], seg[i*2+1])

for _ in range(M):
    a,b = map(int, input().strip().split())
    print(findMin(a,b+1,1,1,segsize+1))