# 줄 세우기
from collections import deque

N,M = map(int,input().split())

graph = [[] for _ in range(N+1)]
indegree = [0 for _ in range(N+1)]
q = deque()

for i in range(M):
    a,b = map(int,input().split())
    graph[a] += [b]
    indegree[b] += 1

for i,k in enumerate(indegree[1:]):
    if k == 0:
        q.append(i+1)

result = []
while q:
    out = q.popleft()
    result.append(out)
    for i in graph[out]:
        indegree[i] -= 1
        if indegree[i] == 0:
            q.append(i)
            
print(" ".join(map(str, result)))

