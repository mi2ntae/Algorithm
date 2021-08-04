# 최솟값 찾기 (sliding window)
from collections import deque
import sys#, heapq
input = sys.stdin.readline

N,L = map(int, input().strip().split())
A = list(map(int, input().strip().split()))
D = []
# heap = []

# for i in range(N):
#     heapq.heappush(heap, (A[i], i))
#     while heap[0][1] <= i-L:
#         heapq.heappop(heap)
#     D.append(heap[0][0])
        
# for i in D[:-1]:
#     print(i,end=" ")
# print(D[-1])

dq = deque()

for i in range(N):
    while dq and dq[-1][0] > A[i]:
        dq.pop()
    dq.append((A[i], i))
    if dq[0][1] == i-L:
        dq.popleft()
    
    D.append(dq[0][0])

for i in D[:-1]:
    print(i,end=" ")
print(D[-1])