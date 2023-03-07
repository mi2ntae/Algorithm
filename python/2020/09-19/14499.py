# 주사위 굴리기

import sys
input = sys.stdin.readline

N,M,x,y,K = map(int, input().split())
mapp = [list(map(int, input().split())) for _ in range(N)]
order = list(map(int, input().split()))
dice = [0 for _ in range(6)]

for i in range(K):
    dx = 0
    dy = 0
    goto = ""
    if order[i] == 1:
        dy = 1
        goto = "E"
    elif order[i] == 2:
        dy = -1
        goto = "W"
    elif order[i] == 3:
        dx = -1
        goto = "N"
    elif order[i] == 4:
        dx = 1
        goto = "S"

    mx = x + dx
    my = y + dy    
    if mx < 0 or mx >= N or my < 0 or my >= M:
        continue

    if goto == "S":
        dice[0],dice[2],dice[4],dice[5] = dice[5],dice[0],dice[2],dice[4]
    elif goto == "N":
        dice[0],dice[2],dice[4],dice[5] = dice[2],dice[4],dice[5],dice[0]
    elif goto == "W":
        dice[3],dice[5],dice[1],dice[2] = dice[5],dice[1],dice[2],dice[3]
    elif goto == "E":
        dice[3],dice[5],dice[1],dice[2] = dice[2],dice[3],dice[5],dice[1]

    if mapp[mx][my] == 0:
        mapp[mx][my] = dice[5]
    else:
        dice[5] = mapp[mx][my]
        mapp[mx][my] = 0
    
    x = mx
    y = my

    print(dice[2])