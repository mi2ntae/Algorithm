# 주식

import sys
input = sys.stdin.readline

def findMax(a,b,cur,l,r):
    if a <= l and r <= b:
        return seg[cur]
    if a >= r or b <= l:
        return 0
    mid = (l+r)//2
    return max(findMax(a,b,cur*2,l,mid), findMax(a,b,cur*2+1,mid,r))

T = int(input().strip())

for _ in range(T):
    N = int(input().strip())
    stock_price = list(map(int, input().strip().split()))

    stock_count = 0
    ans = 0

    segsize = 2
    while segsize < N:
        segsize *= 2

    seg = [0] * segsize * 2
    for i in range(N):
        seg[segsize+i] = stock_price[i]

    for i in range(segsize-1,0,-1):
        seg[i] = max(seg[i*2], seg[i*2+1])

    maxv = findMax(0,N,1,0,segsize)
    for i in range(N):
        if stock_price[i] == maxv:
            ans += stock_price[i] * stock_count
            stock_count = 0
            maxv = findMax(i+1,N,1,0,segsize)
        else:
            ans -= stock_price[i]
            stock_count += 1
        
    print(ans)