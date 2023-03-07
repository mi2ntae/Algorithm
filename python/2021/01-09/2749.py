# 피보나치 수 3

# class Matrix:
#     def __init__(self, elements):
#         self.value = elements
#         self.N = len(elements)

#     def __mul__(self, other):
#         res = [[0],[0]]
#         for r in range(2):
#             for k in range(2):
#                 res[r][0] = (res[r][0] + self.value[k][0] * other.value[r][k]) % 1000000
#         print(res)
#         return Matrix(res)

# N = int(input())
# mat = Matrix([[1,1], [1,0]])
# ans = Matrix([[1],[0]])

# for i in range(61):
#     if (N >> i) & 1 == 1:
#         ans *= mat
#     mat *= mat

# print(ans[0])
import sys
input = sys.stdin.readline

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
                    res[r][c] = (res[r][c] + self.value[r][k] * other.value[k][c]) % 1000000

        return Matrix(res)

B = int(input())-1
N = 2
mat = Matrix([[1,1],[1,0]])
ans = Matrix([[1 if r == c else 0 for c in range(N)] for r in range(N)])

for i in range(61):
    if (B >> i) & 1 == 1:
        ans *= mat
    mat *= mat

print(ans)