# 가운데를 말해요

import sys, heapq
input = sys.stdin.readline

N = int(input().strip())

lheap = [10001]
rheap = [10001]

for _ in range(N):
    num = int(input().strip())
    if rheap[0] <= num:
        heapq.heappush(rheap, num)
    else:
        heapq.heappush(lheap, -num)

    if len(lheap) < len(rheap):
        heapq.heappush(lheap, -heapq.heappop(rheap))
    elif len(rheap)+1 < len(lheap):
        heapq.heappush(rheap, -heapq.heappop(lheap))
    
    print(-lheap[0])