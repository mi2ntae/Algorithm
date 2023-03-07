# def func(limit=5):
#     if limit == 0:
#         return
#     a = 1
#     func(limit-1)

# func()

# DFS 깊이우선탐색
# 노드 개수 N, 엣지 개수 E
# 인접행렬방식 : 각 노드가 직접적으로 연결되어 있는지 저장, 노드 개수의 제곱만큼 메모리를 사용함(N**2) 노드간의 연결관계를 알기 쉬움
# 인접리스트방식 : 각 노드마다 배열을 만들어 인접해있는 노드를 저장, 

# 인접리스트방식을 이용한 촌수계산
import sys
sys.setrecursionlimit(10000000)

N = int(input())

i, j = map(int,input().split())
E = int(input())

graph = [[] for _ in range(N+1)]
for _ in range(E):
    u, v = map(int,input().split())
    graph[u] += [v]
    graph[v] += [u]

def DFS(cur, bef, dst, dep=0):
    if cur == dst:
        return dep
    for nxt in graph[cur]:
        if bef == nxt:
            continue
        ret = DFS(nxt, cur, dst, dep+1)
        if ret != -1:
            return ret
    return -1

print(DFS(i,0,j,0))