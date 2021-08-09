# 최단경로

import heapq

V,E = map(int, input().split())
K = int(input())

heap = [(0,K)]
graph = [[] for _ in range(V+1)]
isVisited = [False for _ in range(V+1)]
ans = [-1 for _ in range(V+1)]
ans[K] = 0

for i in range(E):
    u,v,w = map(int, input().split())
    graph[u].append((w,v))

while heap:
    w, cur = heapq.heappop(heap)
    if isVisited[cur]:
        continue
    
    isVisited[cur] = True
    ans[cur] = w

    for i in graph[cur]:
        if isVisited[i[1]]:
            continue
        heapq.heappush(heap, (i[0]+w, i[1]))

for i in ans[1:]:
    if i == -1:
        print("INF")
    else:
        print(i)