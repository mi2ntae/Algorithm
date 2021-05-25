# DFS 유기농 배추
import sys
sys.setrecursionlimit(10000000)

T = int(input())

def jirungi(n, m):
    isvisited[n][m] = True
    dx = [0, -1, 1, 0]
    dy = [-1, 0, 0, 1]

    for i in range(4):
        nx = m + dx[i]
        ny = n + dy[i]

        if nx != -1 \
            and ny != -1 \
            and nx != M \
            and ny != N \
            and not isvisited[ny][nx] \
            and baechu[ny][nx] == 1:
            jirungi(ny,nx)

for _ in range(T):
    a = input().split()
    M = int(a[0])
    N = int(a[1])
    K = int(a[2])

    baechu = [[0 for _ in range(M)] for _ in range(N)]
    isvisited = [[False for _ in range(M)] for _ in range(N)]

    count = 0

    for i in range(K):
        a,b = input().split()
        a = int(a)
        b = int(b)
        baechu[b][a] = 1

    for n in range(N):
        for m in range(M):
            if not isvisited[n][m] and baechu[n][m] == 1:
                count += 1
                jirungi(n, m)

    print(count)