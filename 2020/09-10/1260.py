# DFS와 BFS

import sys
from collections import deque

sys.setrecursionlimit(1000000)

N,M,V = map(int,input().split())
dfsR = []
bfsR = []

isvisited = [False for _ in range(N+1)]
graph = [[] for _ in range(N+1)]

for i in range(M):
    a,b = map(int, input().split())
    graph[a] += [b]
    graph[b] += [a]

for k in graph:
    k = k.sort()

def DFS(n):
    isvisited[n] = True
    dfsR.append(n)

    for i in graph[n]:
        if isvisited[i] == False:
            DFS(i)

DFS(V)

q = deque()
isvisited = [False for _ in range(N+1)]
q.append(V)
isvisited[V] = True

while q:
    cur = q.popleft()
    bfsR.append(cur)

    for i in graph[cur]:
        if isvisited[i] == False:
            q.append(i)
            isvisited[i] = True

print(" ".join(map(str, dfsR)))
print(" ".join(map(str, bfsR)))
