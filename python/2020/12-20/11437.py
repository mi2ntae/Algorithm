# LCA

import sys
sys.setrecursionlimit(50010)
input = sys.stdin.readline

N = int(input())

graph = [[] for _ in range(N+1)]

for _ in range(N-1):
    u, v = map(int, input().split())
    graph[u].append(v)
    graph[v].append(u)

levels = [None] * (N+1)
tree = [[] for _ in range(N+1)]
sparse = [[1 for _ in range(int.bit_length(N))] for _ in range(N+1)]


def build(tree, levels, sparse, cur, bef, step = 0):
    levels[cur] = step
    for nxt in graph[cur]:
        if nxt == bef:
            continue
        sparse[nxt][0] = cur
        tree[cur].append(nxt)
        build(tree, levels, sparse, nxt, cur, step+1)

build(tree, levels, sparse, 1, 0)

for l in range(1, int.bit_length(N)):
    for u in range(1, N+1):
        sparse[u][l] = sparse[sparse[u][l-1]][l-1]

def match_level(levels, sparse, u, v):
    if levels[u] < levels[v]:
        u, v = v, u

    for l in range(int.bit_length(N)-1, -1, -1):
        if levels[v] <= levels[sparse[u][l]]:
            u = sparse[u][l]

    return u, v

def common_ancester(levels, sparse, u, v):
    u, v = match_level(levels, sparse, u, v)
    if u == v:
        return u

    for l in range(int.bit_length(N)-1, -1, -1):
        if sparse[u][l] != sparse[v][l]:
            u = sparse[u][l]
            v = sparse[v][l]

    return sparse[u][0]

M = int(input())
for _ in range(M):
    u, v = map(int, input().split())
    print(common_ancester(levels, sparse, u, v))