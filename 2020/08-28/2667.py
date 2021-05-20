# 재귀 단지번호붙이기
import sys
sys.setrecursionlimit(10000000)

limit = int(input())
houses = [input() for _ in range(limit)]
visited = [[False for _ in range(limit)] for _ in range(limit)]

danji = 0
danji_count = []

def DFS(i, j):
    visited[i][j] = True
    di = [-1, 0, 0, 1]
    dj = [0, -1, 1, 0]

    danji_count[danji-1] += 1 

    for k in range(4):
        ni = i+di[k]
        nj = j+dj[k]

        if ni != -1 \
            and nj != -1 \
            and ni != limit \
            and nj != limit \
            and not visited[ni][nj] \
            and houses[ni][nj] == "1": 
            DFS(ni,nj)

for i in range(limit):
    for j in range(limit):
        if houses[i][j] == "1" and not visited[i][j]:
            danji += 1
            danji_count += [0]
            DFS(i,j)

print(danji)
danji_count.sort()
for i in danji_count:
    print(i)
