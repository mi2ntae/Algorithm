# 재귀 안전 영역
import sys
sys.setrecursionlimit(10000000)

N = int(input())

area = [[0 for _ in range(N)] for _ in range(N)]
isVisited = [[False for _ in range(N)] for _ in range(N)]
safezone = []
index = 1

for h in range(N):
    a = input().split()
    for w in range(N):
        area[h][w] = int(a[w])

def safe(w, h, i):
    isVisited[h][w] = True
    dx = [0, -1, 1, 0]
    dy = [-1, 0, 0, 1]
    
    for a in range(4):
        nx = w + dx[a]
        ny = h + dy[a]

        if nx != -1\
            and ny != -1\
            and nx != N\
            and ny != N\
            and not isVisited[ny][nx]\
            and area[ny][nx] >= i:
                safe(nx,ny,i)

for _ in range(100):
    count = 0
    for h in range(N):
        for w in range(N):
            if not isVisited[h][w] and area[h][w] >= index:
                safe(w,h,index)
                count += 1
    isVisited = [[False for _ in range(N)] for _ in range(N)]
    index += 1
    safezone.append(count)

high = 0
for i in safezone:
    if high <= i:
        high = i
print(high)