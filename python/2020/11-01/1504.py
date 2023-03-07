# 특정한 최단 경로
import heapq, sys
input = sys.stdin.readline

N,E = map(int, input().strip().split())
graph = [[] for _ in range(N+1)]

for _ in range(E):
    a,b,w = map(int, input().strip().split())
    graph[a].append((w,b))
    graph[b].append((w,a))

U,V = map(int, input().strip().split())
uans = [-1 for _ in range(N+1)]
vans = [-1 for _ in range(N+1)]

def dijkstra(start, graph, isvisited, ans):
    heap = [(0,start)]
    while heap:
        w, cur = heapq.heappop(heap)
        if isvisited[cur]:
            continue
        
        isvisited[cur] = True
        ans[cur] = w

        for i in graph[cur]:
            if isvisited[i[1]]:
                continue
            heapq.heappush(heap, (i[0]+w, i[1]))

dijkstra(U, graph, [False for _ in range(N+1)], uans)
dijkstra(V, graph, [False for _ in range(N+1)], vans)

if uans[1] == -1 or uans[V] == -1 or vans[N] == -1:
    print("-1")
else:
    print(min(uans[1]+uans[V]+vans[N],vans[1]+vans[U]+uans[N]))