# ACM Craft

from sys import stdin
from collections import deque

input = stdin.readline

T = int(input())
for _ in range(T):
    N,K = map(int, input().split())
    graph = [[] for i in range(N+1)]
    indegree = [0 for _ in range(N+1)]
    q = deque()
    time = [0] + list(map(int, input().split()))
    result = [-1 for _ in range(N+1)]

    for i in range(K):
        a,b = map(int, input().split())
        graph[a] += [b]
        indegree[b] += 1

    W = int(input())

    for i in range(1, N+1):
        if indegree[i] == 0:
            q.append(i)
            result[i] = time[i]
    
    while q:
        cur = q.popleft()
        for i in graph[cur]:
            indegree[i] -= 1
            result[i] = max(result[i], result[cur]+time[i])
            if indegree[i] == 0:
                q.append(i)

    print(result[W])