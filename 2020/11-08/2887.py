# 행성 터널
import sys
sys.setrecursionlimit(10000000)
input = sys.stdin.readline

N = int(input().strip())

edges = []
planet = []
table = list(range(N))

for i in range(N):
    x,y,z = map(int, input().strip().split())
    planet.append((x,y,z,i))

def juldae(x,y):
    return abs(x-y)

def uFind(u):
    if table[u] == u:
        return u

    table[u] = uFind(table[u])

    return table[u]

def uMerge(u,v):
    u = uFind(u)
    v = uFind(v)

    if u != v:
        table[v] = u

planet.sort(key=lambda item: item[0])
for i in range(len(planet)-1):
    dx = (juldae(planet[i][0], planet[i+1][0]),planet[i][3], planet[i+1][3])
    edges.append(dx)

planet.sort(key=lambda item: item[1])
for i in range(len(planet)-1):
    dy = (juldae(planet[i][1], planet[i+1][1]),planet[i][3], planet[i+1][3])
    edges.append(dy)

planet.sort(key=lambda item: item[2])
for i in range(len(planet)-1):
    dz = (juldae(planet[i][2], planet[i+1][2]),planet[i][3], planet[i+1][3])
    edges.append(dz)

ans = 0
cnt = 0

edges.sort()

for i in edges:
    if uFind(i[1]) != uFind(i[2]):
        uMerge(i[1], i[2])
        ans += i[0]
        cnt += 1
        if cnt == N-1:
            break

print(ans)