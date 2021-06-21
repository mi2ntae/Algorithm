# BFS를 이용한 촌수계산

from queue import Queue

N = int(input())
u, v = map(int, input().split())
M = int(input())

graph = [[] for _ in range(N+1)]

for _ in range(M):
    i,j = map(int, input().split())
    graph[i] += [j]
    graph[j] += [i]

isVisited = [False for _ in range(N+1)]

q = Queue()
q.put(u)
isVisited[u] = True
distance = [0x3f3f3f3f for _ in range(N+1)]
distance[u] = 0

while not q.empty():
    cur = q.get()
    for nxt in graph[cur]:
        if not isVisited[nxt]:
            q.put(nxt)
            isVisited[nxt] = True
            distance[nxt] = distance[cur] + 1
            if nxt == v:
                break

if not isVisited[v]:
    print("-1")
else:
    print(distance[v])