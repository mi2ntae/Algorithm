# 트럭

import sys
from collections import deque
input = sys.stdin.readline

N,W,L = map(int, input().strip().split())
truck = list(map(int, input().strip().split()))

q = deque()
q.append([truck[0],W])
b_count = 1
b_weihgt = truck[0]
idx = 1

ans = 1

while q:
    for i in range(len(q)):
        q[i][1] -= 1

    if q[0][1] == 0:
        b_count -= 1
        b_weihgt -= q[0][0]
        q.popleft()

    ans += 1
    if idx == len(truck):
        continue
    if b_count == W:
        continue
    if b_weihgt + truck[idx] > L:
        continue
    q.append([truck[idx],W])
    b_count += 1
    b_weihgt += truck[idx]
    idx += 1

print(ans)