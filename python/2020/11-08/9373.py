# 복도 뚫기

import sys, math
sys.setrecursionlimit(10000)
input = sys.stdin.readline

T = int(input().strip())

def uFind(u, table):
    if table[u] == u:
        return u

    table[u] = uFind(table[u],table)

    return table[u]

def uMerge(u, v, table):
    u = uFind(u,table)
    v = uFind(v,table)

    if u != v:
        table[v] = u

for _ in range(T):
    w = int(input().strip())
    n = int(input().strip())

    sensor = []
    edges = []
    utable = list(range(n+2))

    for _ in range(n):
        x,y,r = map(int, input().strip().split())
        sensor.append((r,x,y))

    edges.append((w,0,1))
    for i in range(n):
        x1 = sensor[i][1]
        y1 = sensor[i][2]
        r1 = sensor[i][0]
        edges.append((x1-r1, i+2, 0))
        edges.append((w-x1-r1, i+2, 1))
        for k in range(i+1,n):
            x2 = sensor[k][1]
            y2 = sensor[k][2]
            r2 = sensor[k][0]
            d = math.sqrt((x1-x2)**2+(y1-y2)**2)-r1-r2
            if d < w:
                edges.append(
                    (
                        d,
                        i+2,
                        k+2
                    )
                )

    edges.sort(key=lambda item: item[0])

    for edge in edges:
        if uFind(edge[1],utable) != uFind(edge[2],utable):
            uMerge(edge[1],edge[2],utable)
        if uFind(0,utable) == uFind(1,utable):
            print("0" if edge[0] < 0 else edge[0]/2)
            break