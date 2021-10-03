# 행렬 제곱

import sys
input = sys.stdin.readline

class Matrix:
    def __init__(self, elements):
        self.value = elements
        self.N = len(elements)

    def __repr__(self):
        ret = []
        for line in self.value:
            ret.append(" ".join(map(str, line)))
        return "\n".join(ret)

    def __mul__(self, other):
        res = [[0 for _ in range(N)] for _ in range(N)]
        for r in range(N):
            for c in range(N):
                for k in range(N):
                    res[r][c] = (res[r][c] + self.value[r][k] * other.value[k][c]) % 1000

        return Matrix(res)

N, B = map(int, input().strip().split())
mat = Matrix([list(map(int, input().strip().split())) for _ in range(N)])
ans = Matrix([[1 if r == c else 0 for c in range(N)] for r in range(N)])

for i in range(37):
    if (B >> i) & 1 == 1:
        ans *= mat
    mat *= mat

print(ans)