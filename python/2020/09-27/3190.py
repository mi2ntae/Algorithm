# 뱀

N = int(input())
board = [[0 for _ in range(N+1)] for _ in range(N+1)]
K = int(input())
for _ in range(K):
    y,x = map(int, input().split())
    board[y][x] = 1

L = int(input())
sett = {}
for _ in range(L):
    t,d = input().split()
    sett[int(t)] = d

isbreak = False
dx = 1
dy = 0
time = 0
wayx = [1]
wayy = [1]
head = "E"
direction = ""
x = 1
y = 1

while True:
    x += dx
    y += dy
    time += 1
    if x <= 0 or x > N or y <= 0 or y > N:
        print(time)
        isbreak = True
    
    for i in range(len(wayx)):
        if wayx[i] == x and wayy[i] == y:
            print(time)
            isbreak = True
    
    if isbreak:
        break

    wayx.append(x)
    wayy.append(y)
    if board[y][x] == 1:
        board[y][x] = 0
    else:
        wayx = wayx[1:]
        wayy = wayy[1:]
    
    dx = 0
    dy = 0

    for i in sett:
        if time == i:
            direction = sett[i]
    
    if direction == "D":
        if head == "N":
            dx = 1
            head = "E"
        elif head == "W":
            dy = -1
            head = "N"
        elif head == "E":
            dy = 1
            head = "S"
        elif head == "S":
            dx = -1
            head = "W"
    elif direction == "L":
        if head == "N":
            dx = -1
            head = "W"
        elif head == "W":
            dy = 1
            head = "S"
        elif head == "E":
            dy = -1
            head = "N"
        elif head == "S":
            dx = 1
            head = "E"
    else:
        if head == "N":
            dy = -1
        elif head == "W":
            dx = -1
        elif head == "E":
            dx = 1
        elif head == "S":
            dy = 1
    direction = ""