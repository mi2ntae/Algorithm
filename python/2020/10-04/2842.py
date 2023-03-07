# 집배원 한상덕

N = int(input())
town = [input() for _ in range(N)]
height = [list(map(int, input().split())) for _ in range(N)]
isvisited = {}
px = 0
py = 0
k = 0
for m in range(N):
    for n in range(N):
        if town[m][n] == "P":
            px = n
            py = m
            high = height[m][n]
            low = high
        if town[m][n] == "K":
            k += 1
            isvisited[m,n] = False

x = px
y = py
dst = False
while not dst:
    if x == 0:
        dx = [0, 0, 1, 0, 1, 0, 0, 1]
    elif x == N-1:
        dx = [-1, 0, 0, -1, 0, -1, 0, 0]
    else:
        dx = [-1, 0, 1, -1, 1, -1, 0, 1]

    if y == 0:
        dy = [0, 0, 0, 0, 0, 1, 1, 1]
    elif y == N-1:
        dy = [-1, -1, -1, 0, 0, 0, 0, 0]
    else:
        dy = [-1, -1, -1, 0, 0, 1, 1, 1]
    
    for i in range(8):
        if dx[i] == 0 and dy[i] = 0:
            continue
        mx = x+dx[i]
        my = y+dy[i]
        mheight = height[my][mx]

        if k == 0 and town[my][mx] == "P":
            x = mx
            y = my
            dst = True
            break
        elif town[my][mx] == "K" and not isvisited[my,mx]:
            x = mx
            y = my
            k -= 1
        

