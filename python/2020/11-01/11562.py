# 백양로 브레이크
import sys, heapq
input = sys.stdin.readline

n,m = map(int, input().strip().split())
graph = [[] for i in range(n+1)]
ans = [[0]]

for i in range(m):
    u,v,b = map(int, input().strip().split())
    graph[u].append((0,v))
    graph[v].append((1 if b == 0 else 0, u))

def dijkstra(start, graph, isvisited, heap, ans):
    while heap:
        cur = heapq.heappop(heap)  
        if isvisited[cur[1]]:
            continue
        isvisited[cur[1]] = True
        ans[cur[1]] = cur[0]
        
        for i in graph[cur[1]]:
            if isvisited[i[1]]:
                continue
            heapq.heappush(heap, (i[0]+cur[0], i[1]))
        print("heappop : ",cur[0], cur[1])
    return ans

k = int(input().strip())
for i in range(1,n+1):
    print("----",i,"-----")
    ans.append(dijkstra(i, graph, [False for _ in range(n+1)], [(0,i)], [m+1 for _ in range(n+1)]))
    print("-------------")

for i in range(k):
    s,e = map(int, input().strip().split())
    print("ans : ",ans[s][e])