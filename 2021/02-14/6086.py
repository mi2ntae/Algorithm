# 최대 유량

from string import ascii_lowercase, ascii_uppercase
from collections import deque

N = int(input())

graph = {k: {_k: 0 for _k in (ascii_lowercase + ascii_uppercase)} for k in (ascii_lowercase + ascii_uppercase)}

for _ in range(N):
    u, v, c = input().split()
    c = int(c)
    graph[u][v] += c
    graph[v][u] += c

def bfs(src, dst):
    vst = set()
    q = deque()
    q.append(src)
    vst.add(src)

    footprint = {}

    while q:
        cur = q.popleft()
        for nxt in (ascii_lowercase + ascii_uppercase):
            if 0 < graph[cur][nxt] and nxt not in vst:
                q.append(nxt)
                vst.add(nxt)
                footprint[nxt] = cur

    ret = []
    cur = dst
    while cur in footprint:
        ret.append((footprint[cur], cur))
        cur = footprint[cur]
        
    return ret

ans = 0

while True:
    path = bfs('A', 'Z')

    if not path:
        break

    mv = 0x3f3f3f3f
    for u, v in path:
        mv = min(mv, graph[u][v])

    ans += mv

    for u, v in path:
        graph[u][v] -= mv
        graph[v][u] += mv

print(ans)