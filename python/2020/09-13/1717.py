# 집합의 표현 disjoint set

import sys
sys.setrecursionlimit(10000000)
input = sys.stdin.readline

N,M = map(int,input().split())
st = [i for i in range(N+1)] # tree

def uFind(cur):
    if st[cur] == cur:
        return cur
    
    # tree를 압축
    st[cur] = uFind(st[cur])
    return st[cur]
    
def uMerge(a,b):
    a = uFind(a)
    b = uFind(b)
    if a == b:
        return
    
    st[b] = a

for i in range(M):
    a,b,c = map(int, input().split())
    if a == 0:
        uMerge(b,c)
    else:
        if uFind(b) == uFind(c):
            print("YES")
        else:
            print("NO")

