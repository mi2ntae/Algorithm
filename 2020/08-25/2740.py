# 행렬 곱셈
ai = input().split()
m = int(ai[1])
n = int(ai[0])

a = [[0]*m for i in range(n)]

for i in range(n):
    inp = input().split()
    for k in range(m):
        a[i][k] = int(inp[k])
        
bi = input().split()
m1 = int(bi[0])
k1 = int(bi[1])

b = [[0]*k1 for i in range(m)]

for i in range(m1):
    inp = input().split()
    for k in range(k1):
        b[i][k] = int(inp[k])

c = [[0]*k1 for i in range(n)]

for o in range(n):
    for p in range(k1):
        num = 0
        for i in range(m):
            num += a[o][i]*b[i][p]
        c[o][p] = num
        print(c[o][p], end=" ")
    print("")