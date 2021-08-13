# 복제 로봇

import sys
from collections import deque
input = sys.stdin.readline

def bfs(maze, index, i, j):
    direction = [(0, -1), (0, 1), (-1, 0), (1, 0)]

    edges = []
    vst = [[False for _ in range(N)] for _ in range(N)]
    distance = [[0x3f3f3f3f for _ in range(N)] for _ in range(N)]
    q = deque([(i, j)])
    vst[i][j] = True
    distance[i][j] = 0
    while q:
        curr, curc = q.popleft()
        for dr, dc in direction:
            nextr = curr + dr
            nextc = curc + dc
            if maze[nextr][nextc] != '1' and not vst[nextr][nextc]:
                vst[nextr][nextc] = True
                q.append((nextr, nextc))
                distance[nextr][nextc] = distance[curr][curc] + 1
                if maze[nextr][nextc] != '0':
                    edges.append((distance[nextr][nextc], index[i][j], index[nextr][nextc]))
    return edges


N, M = map(int, input().strip().split())
maze = [input().strip() for _ in range(N)]

edges = []
index = [[None for _ in range(N)] for _ in range(N)]
last_index = 0
for i in range(N):
    for j in range(N):
        if maze[i][j] in ['K', 'S']:
            index[i][j] = last_index
            last_index += 1

for i in range(N):
    for j in range(N):
        if maze[i][j] in ['K', 'S']:
            edges.extend(bfs(maze, index, i, j))

if len(edges) != (M+1) * M:
    print("-1")
    exit(0)

edges.sort()

chief = list(range(M+1))
def ufind(u):
    if chief[u] == u:
        return u
    chief[u] = ufind(chief[u])
    return chief[u]

ans = 0
last_edge = 0
for _ in range(M):
    while ufind(edges[last_edge][1]) == ufind(edges[last_edge][2]):
        last_edge += 1
    chief[ufind(edges[last_edge][1])] = ufind(edges[last_edge][2])
    ans += edges[last_edge][0]
    last_edge += 1

print(ans)