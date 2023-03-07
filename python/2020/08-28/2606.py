# 재귀 바이러스 컴퓨터
import sys
sys.setrecursionlimit(10000000)

N = int(input())
E = int(input())

count = 0
graph = [[] for _ in range(N+1)]


for _ in range(E):
    i, j = map(int,input().split())
    graph[i] += [j]
    graph[j] += [i]

isvisited = [False] * (N+1)

def virus(cur):
    global count
    isvisited[cur] = True
    for i in graph[cur]:
        if not isvisited[i]:
            count += 1
            # print(f'{cur} -> {i}')
            virus(i)

virus(1)
print(count)