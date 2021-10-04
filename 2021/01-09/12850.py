# 본대 산책

class Matrix:
    def __init__(self, elements):
        self.value = elements
        self.N = len(elements)

    def __repr__(self):
        return str(self.value[0][0])

    def __mul__(self, other):
        res = [[0 for _ in range(N)] for _ in range(N)]
        for r in range(N):
            for c in range(N):
                for k in range(N):
                    res[r][c] = (res[r][c] + self.value[r][k] * other.value[k][c]) % 1000000007

        return Matrix(res)

D = int(input())
N = 8
mat = Matrix([
    [0,1,0,0,0,0,0,1],
    [1,0,1,0,0,0,0,1],
    [0,1,0,1,0,0,1,1],
    [0,0,1,0,1,0,1,0],
    [0,0,0,1,0,1,0,0],
    [0,0,0,0,1,0,1,0],
    [0,0,1,1,0,1,0,1],
    [1,1,1,0,0,0,1,0]
    ])
ans = Matrix([[1 if r == c else 0 for c in range(N)] for r in range(N)])

for i in range(37):
    if (D >> i) & 1 == 1:
        ans *= mat
    mat *= mat

print(ans)
