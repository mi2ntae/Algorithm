# 문제집 : 위상정렬
from sys import stdin

input = stdin.readline

class MyHeap():
    @staticmethod
    def push(heap, value):
        cur = len(heap)
        heap.append(value)
        while cur > 1:
            if heap[cur//2] > heap[cur]:
                heap[cur//2],heap[cur] = heap[cur],heap[cur//2]
                cur = cur //2
            else:
                break
    @staticmethod
    def pop(heap):
        val = heap[1]
        if len(heap) == 2:
            return heap.pop()
        heap[1] = heap.pop()
        cur = 1
        while True:
            if cur*2 >= len(heap):
                break
            elif cur*2 == len(heap)-1:
                if heap[cur] > heap[cur*2]:
                    heap[cur],heap[cur*2] = heap[cur*2],heap[cur]
                break
            else:
                if heap[cur*2] > heap[cur*2+1] and heap[cur*2+1] < heap[cur]:
                    heap[cur*2+1],heap[cur] = heap[cur],heap[cur*2+1]
                    cur = cur*2+1
                elif heap[cur*2] <= heap[cur*2+1] and heap[cur*2] < heap[cur]:
                    heap[cur*2],heap[cur] = heap[cur],heap[cur*2]
                    cur = cur*2
                else:
                    break
        return val

N,M = map(int, input().split())

graph = [[] for _ in range(N+1)]
indegree = [0 for _ in range(N+1)]
result = []
heap = [0]

for i in range(M):
    a,b = map(int, input().split())
    graph[a] += [b]
    indegree[b] += 1

for i,k in enumerate(indegree[1:]):
    if k == 0:
        MyHeap.push(heap, i+1)

while len(heap) > 1:
    cur = MyHeap.pop(heap)
    result.append(cur)

    for a in graph[cur]:
        indegree[a] -= 1
        if indegree[a] == 0:
            MyHeap.push(heap, a)

print(" ".join(map(str,result)))