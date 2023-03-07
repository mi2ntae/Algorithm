# 여행 계획 세우기

from collections import deque
import sys
sys.setrecursionlimit(500100)
input = sys.stdin.readline

N,M,S,T = map(int, input().strip().split())

graph = [[] for _ in range(N+1)]
for _ in range(M):
    s,d = map(int, input().strip().split())
    graph[s].append(d)

footprint = [False for _ in range(N+1)]
stack = []
scc_idx = [0 for _ in range(N+1)]
idx = [-1 for _ in range(N+1)]
node_count = []
NN = 0
last_idx = 1
where = [0 for _ in range(N+1)]

def build_scc(cur):
    global last_idx, NN
    idx[cur] = last_idx
    scc_idx[cur] = last_idx
    last_idx += 1
    stack.append(cur)
    footprint[cur] = True
    for nxt in graph[cur]:
        if idx[nxt] == -1:
            build_scc(nxt)
            scc_idx[cur] = min(scc_idx[cur], scc_idx[nxt])
        if footprint[nxt]:
            scc_idx[cur] = min(scc_idx[cur], scc_idx[nxt])
    if idx[cur] == scc_idx[cur]:
        NN += 1
        scc_index = NN - 1
        total_amount = 1
        while stack[-1] != cur:
            where[stack[-1]] = scc_index
            footprint[stack[-1]] = False
            total_amount += 1
            stack.pop()
        where[cur] = scc_index
        footprint[cur] = False
        node_count.append(total_amount)
        stack.pop()

for i in range(1,N+1):
    if idx[i] == -1:
        build_scc(i)

del idx
del footprint
del scc_idx

ngraph = [set() for _ in range(NN)]
ind = [0 for _ in range(NN)]
for i, edges in enumerate(graph[1:]):
    node = i + 1
    for nxt in edges:
        if where[node] != where[nxt] and where[nxt] not in ngraph[where[node]]:
            ngraph[where[node]].add(where[nxt])
            ind[where[nxt]] += 1

del graph

S = where[S]
ind[S] += 1 # S이전의 엣지들을 전처리하기위함
q = deque()
for i in range(NN):
    if ind[i] == 0:
        q.append(i)

while q:
    cur = q.popleft()
    for nxt in ngraph[cur]:
        ind[nxt] -= 1
        if ind[nxt] == 0:
            q.append(nxt)

q.append(S)
max_income = [0 for _ in range(NN)]
max_income[S] = node_count[S]
while q:
    cur = q.popleft()
    for nxt in ngraph[cur]:
        ind[nxt] -= 1
        max_income[nxt] = max(max_income[nxt], max_income[cur] + node_count[nxt])
        if ind[nxt] == 0:
            q.append(nxt)
            
print(max_income[where[T]])