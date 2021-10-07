# 정수 수열

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
                    res[r][c] = (res[r][c] + self.value[r][k] * other.value[k][c]) % 100

        return Matrix(res)

x, y, a, b, n = map(int, input().strip().split())
B = n
N = 2
mat = Matrix([
    [x, y],
    [1, 0]])
ans = Matrix([[1 if r == c else 0 for c in range(N)] for r in range(N)])

for i in range(60):
    if (B >> i) & 1 == 1:
        ans *= mat
    mat *= mat

print(f"{(ans.value[1][0] * b + ans.value[1][1] * a) % 100 :02d}")

