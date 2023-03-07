# 배열에서 이동

import sys
from collections import deque
input = sys.stdin.readline

N = int(input().strip())
grid = []
nums = []
for _ in range(N):
    a = list(map(int, input().strip().split()))
    nums.extend(a)
    grid.append(a)

def bfs(minv,maxv,isvisited):
    if grid[0][0] < minv or grid[0][0] > maxv:
        return False
    q.append((0,0))
    isvisited[0][0] = True

    while q:
        x,y = q.popleft()

        dx = [0,-1,1,0]
        dy = [-1,0,0,1]
        for i in range(4):
            mx = x+dx[i]
            my = y+dy[i]
            if mx >= 0 and my >= 0 and \
                mx < N and my < N and \
                not isvisited[my][mx] and \
                grid[my][mx] >= minv and \
                grid[my][mx] <= maxv:
                isvisited[my][mx] = True
                q.append((mx,my))
    
    return isvisited[N-1][N-1]

nnums = set(nums)
nums = list(nnums)
nums.sort()

q = deque()
tail = 0
head = 0
ans = 200

while head < len(nums):
    isvisited = [[False for _ in range(N)] for _ in range(N)]

    if tail > head:
        break
    if bfs(nums[tail], nums[head], isvisited):
        ans = min(ans, nums[head]-nums[tail])
        tail += 1
    else:
        head += 1

print(ans)