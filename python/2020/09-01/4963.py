# 재귀 섬의 개수
import sys
sys.setrecursionlimit(10000000)

W,H = input().split()
W = int(W)
H = int(H)

def findIsland(w, h):
    isVisited[h][w] = True
    dx = [-1, 0, 1, -1, 0, 1, -1, 0, 1]
    dy = [-1, -1, -1, 0, 0, 0, 1, 1, 1]
    for i in range(9):
        nx = w + dx[i]
        ny = h + dy[i]
        if nx != -1 \
            and ny != -1 \
            and nx != W \
            and ny != H \
            and not isVisited[ny][nx] \
            and islands[ny][nx] == "1":
                findIsland(nx,ny)

while W != 0 and H != 0:
    islands = [["0" for _ in range(W)] for _ in range(H)]
    isVisited = [[False for _ in range(W)] for _ in range(H)]
    for i in range(H):
        k = input().split()
        for l in range(W):
            islands[i][l] = k[l]
   
    num = 0
    for h in range(H):
        for w in range(W):
            if not isVisited[h][w] and islands[h][w] == "1":
                findIsland(w,h)
                num += 1
   
    print(num)
    W,H = input().split()
    W = int(W)
    H = int(H)
