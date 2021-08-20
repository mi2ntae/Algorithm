# LCS3
import sys
input = sys.stdin.readline

A = input().strip()
B = input().strip()
C = input().strip()
lenA = len(A)
lenB = len(B)
lenC = len(C)

mapp = [[[0 for _ in range(lenC+1)] for _ in range(lenB+1)] for _ in range(lenA+1)]

for a in range(1,lenA+1):
    for b in range(1,lenB+1):
        for c in range(1,lenC+1):
            if A[a-1] == B[b-1] and A[a-1] == C[c-1]:
                mapp[a][b][c] = mapp[a-1][b-1][c-1] + 1
            else:
                mapp[a][b][c] = max(mapp[a-1][b][c], mapp[a][b-1][c], mapp[a][b][c-1])

print(mapp[lenA][lenB][lenC])