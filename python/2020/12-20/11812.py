# K진 트리

import sys
input = sys.stdin.readline

N,K,Q = map(int, input().strip().split())

def getLv(n, lev=0):
    piv = K**lev
    while n > piv:
        lev += 1
        piv += K**lev
        
    return lev

for _ in range(Q):
    a,b = map(int, input().strip().split())
    if K == 1:
        print(a-b if a >= b else b-a)
    else:
        interval = 0
        height = 1
        al = getLv(a)
        bl = getLv(b)
        if bl > al:
            a,b = b,a
            al,bl = bl,al

        while al != bl:
            a = a//K if a%K == 0 or a%K == 1 else a//K+1
            al -= 1
            interval += 1
        
        if a == b:
            print(interval)
        else:
            a = a//K if a%K == 0 or a%K == 1 else a//K+1
            b = b//K if b%K == 0 or b%K == 1 else b//K+1
            while a != b:
                a = a//K if a%K == 0 or a%K == 1 else a//K+1
                b = b//K if b%K == 0 or b%K == 1 else b//K+1
                height += 1
            print(2*height + interval)