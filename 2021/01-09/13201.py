# 즉흥 여행

import sys
input = sys.stdin.readline

class Matrix:
    def __init__(self, elements):
        self.value = elements
        self.N = len(elements)

    def __mul__(self, other):
        res = [[0 for _ in range(N)] for _ in range(N)]
        for r in range(N):
            for c in range(N):
                for k in range(N):
                    res[r][c] = (res[r][c] + self.value[r][k] * other.value[k][c])

        return Matrix(res)

T = int(input().strip())

for _ in range(T):
    N,K = map(int, input().strip().split())
    airport = [input().strip() for _ in range(N)]
    go = [list(map(int, input().strip().split())) for _ in range(N)]
    idx = 0

    for i,v in enumerate(airport):
        if v == "ICN":
            idx = i

    for r in range(N):
        s = sum(go[r])
        if s != 0:
            for c in range(N):
                go[r][c] /= s

    for i in range(N):
        for j in range(i+1,N):
            go[i][j],go[j][i] = go[j][i],go[i][j]

    mat = Matrix(go)
    ans = Matrix([[1 if r == c else 0 for c in range(N)] for r in range(N)])

    for i in range(12):
        if (K >> i) & 1 == 1:
            ans *= mat
        mat *= mat

    maxv = 0
    ret = 0
    for i in range(N):
        if maxv <= ans.value[i][idx]:
            ret = i
            maxv = ans.value[i][idx]
    
    print(airport[ret])
    
