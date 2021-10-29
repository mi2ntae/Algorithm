# Strongly Connected Component

from sys import setrecursionlimit, stdin
setrecursionlimit(100010)
input = stdin.readline

N, E = map(int, input().strip().split())

graph = [[] for _ in range(N+1)]

for _ in range(E):
    u, v = map(int, input().strip().split())
    graph[u].append(v)

idx = [0 for _ in range(N+1)]
scc_id = [0 for _ in range(N+1)]
stk = []
footprint = [False for _ in range(N+1)]
vst = [False for _ in range(N+1)]
sccs = []

def build_scc(cur):
    idx[cur], scc_id[cur] = build_scc.last_idx, build_scc.last_idx
    build_scc.last_idx += 1
    footprint[cur] = True
    vst[cur] = True
    stk.append(cur)

    for nxt in graph[cur]:
        if not vst[nxt]:
            build_scc(nxt)
            scc_id[cur] = min(scc_id[cur], scc_id[nxt])
        if footprint[nxt]:
            scc_id[cur] = min(scc_id[cur], scc_id[nxt])

    if idx[cur] == scc_id[cur]:
        sccs.append([])
        while stk[-1] != cur:
            footprint[stk[-1]] = False
            sccs[-1].append(stk[-1])
            stk.pop()
        footprint[cur] = False
        sccs[-1].append(cur)
        stk.pop()


build_scc.last_idx = 1

for u in range(1, N+1):
    if not vst[u]:
        build_scc(u)

print(len(sccs))
for i in range(len(sccs)):
    sccs[i].sort()
sccs.sort()
for scc in sccs:
    print(*scc, -1)