# 커피숍2

import sys
input = sys.stdin.readline

def findSum(x,y,cur,l,r):
    if l >= x and y >= r:
        return segtree[cur]
    if y <= l or x >= r:
        return 0
    
    mid = (l+r)//2
    return findSum(x,y,cur*2,l,mid) + findSum(x,y,cur*2+1,mid,r)

def setTree(a,b):
    global segsize
    t = segsize+a-1
    segtree[t] = b
    t //= 2
    while t >= 1:
        segtree[t] = segtree[t*2]+segtree[t*2+1]
        t //= 2

N,Q = map(int, input().strip().split())
nums = list(map(int, input().strip().split()))

segsize = 2
while segsize < N:
    segsize *= 2

segtree = [0 for _ in range(segsize*2)]

for i in range(N):
    segtree[segsize+i] = nums[i]

for i in range(segsize-1,0,-1):
    segtree[i] = segtree[i*2] + segtree[i*2+1]

for _ in range(Q):
    x,y,a,b = map(int, input().strip().split())
    if x > y:
        x,y = y,x
    print(findSum(x,y+1,1,1,segsize+1))
    setTree(a,b)