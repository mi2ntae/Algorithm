# 파티
import sys, heapq
input = sys.stdin.readline

N,M,X = map(int, input().strip().split())
graph = [[] for _ in range(N+1)]
ans = [0]

for i in range(M):
    u,d,t = map(int, input().strip().split())
    graph[u].append((t,d))

def dijkstra(start, isvisited, graph, heap, tmp):
    global X
    while heap:
        cur = heapq.heappop(heap)
        if isvisited[cur[1]]:
            continue
        
        isvisited[cur[1]] = True
        tmp[cur[1]] = cur[0]
        for i in graph[cur[1]]:
            if isvisited[i[1]]:
                continue
            heapq.heappush(heap, (i[0]+cur[0], i[1]))
    return tmp

for i in range(1,N+1):
    tmp = dijkstra(i, [False for _ in range(N+1)], graph, [(0,i)], [0 for _ in range(N+1)])
    ans.append(tmp[X])

xtmp = dijkstra(X, [False for _ in range(N+1)], graph, [(0,X)], [0 for _ in range(N+1)])
for i in range(1,N+1):
    ans[i] += xtmp[i]

print(max(ans))