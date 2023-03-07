# 도시 분할 계획
import sys
input = sys.stdin.readline
sys.setrecursionlimit(10000000)

N,M = map(int, input().strip().split())
edge = []
table = [n for n in range(N+1)]

def uFind(u):
    if table[u] == u:
        return u

    table[u] = uFind(table[u])

    return table[u]

def uMerge(u,v):
    u = uFind(u)
    v = uFind(v)

    if u != v:
        table[v] = u
        
for _ in range(M):
    u,d,w = map(int, input().strip().split())
    edge.append((w,u,d))

edge.sort()
ans = 0
cnt = 0
for w,u,d in edge:
    if uFind(u) != uFind(d):
        uMerge(u,d)
        ans += w
        cnt += 1
        if cnt == N-2:
            break

print(ans)