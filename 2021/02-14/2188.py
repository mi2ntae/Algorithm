# 축사 배정

from collections import deque
import sys
input = sys.stdin.readline

N,M = map(int, input().strip().split())

q = deque()
rooms = [0 for _ in range(M+1)]
wants = [0]

def flow(cur, d):
    vst = [False for _ in range(N+1)]
    k = rooms[cur]
    rooms[cur] = d
    q.append(k)

    while q:
        a = q.popleft()
        for i in wants[a]:
            if i != cur:
                if rooms[i] == 0:
                    rooms[i] = a
                    break
                if vst[rooms[i]]  
        

for _ in range(N):
    a = list(map(int, input().strip().split()))
    wants.append(a[1:])

for i in range(1,N+1):
    for j in wants[i]:
        if rooms[j] == 0:
            rooms[j] = i
        else:
            flow(j, i)
        