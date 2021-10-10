# 트리의 독립집합

import sys
sys.setrecursionlimit(10100)
input = sys.stdin.readline

N = int(input().strip())
node = [0]+list(map(int, input().strip().split()))

graph = [[] for _ in range(N+1)]
memoization = [[0 for _ in range(2)] for _ in range(N+1)]
ans = 0
way = []

for _ in range(N-1):
    a,b = map(int, input().strip().split())
    graph[a].append(b)
    graph[b].append(a)

def dfs(p,cur,d):
    if memoization[cur][d] != 0:
        return memoization[cur][d]

    if d == 1:
        memoization[cur][d] = node[cur]
    for nxt in graph[cur]:
        if nxt != p:
            if d == 0:
                memoization[cur][d] += max(dfs(cur,nxt,1),dfs(cur,nxt,0))
            else:
                memoization[cur][d] += dfs(cur,nxt,0)
    return memoization[cur][d]

def chase(p,cur,d):
    if d == 1:
        way.append(cur)
        for i in graph[cur]:
            if i == p:
                continue
            chase(cur,i,0)
    else:
        for i in graph[cur]:
            if i == p:
                continue
            if memoization[i][0] > memoization[i][1]:
                chase(cur,i,0)
            else:
                chase(cur,i,1)
        
a = dfs(1,1,1)
b = dfs(1,1,0)
if a >= b:
    ans = a
    chase(1,1,1)
else:
    ans = b
    chase(1,1,0)

print(ans)
way.sort()
print(*way)