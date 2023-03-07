# 버블 소트

import sys
input = sys.stdin.readline

def findSum(l,r,x,y,cur):
    if x <= l and y >= r:
        return segtree[cur]
    if l >= y or r <= x:
        return 0
    
    mid = (l+r)//2
    return findSum(l,mid,x,y,cur*2)+findSum(mid,r,x,y,cur*2+1)

def setTree(a):
    global segsize
    a = segsize+a
    segtree[a] += 1
    a //= 2
    while a >= 1:
        segtree[a] = segtree[a*2] + segtree[a*2+1]
        a //= 2

N = int(input().strip())
nums = list(map(int, input().strip().split()))

segsize = 2
while N > segsize:
    segsize *= 2

s_nums = sorted(nums)

dic = {}
for i in range(N):
    dic[s_nums[i]] = i
    
segtree = [0 for _ in range(segsize*2)]
ans = 0
for i in range(N-1,-1,-1):
    k = dic[nums[i]]
    setTree(k)
    ans += findSum(0,segsize,0,k,1)

print(ans)