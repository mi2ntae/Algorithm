# LCS
import sys
input = sys.stdin.readline

A = input().strip()
B = input().strip()
lena = len(A)
lenb = len(B)
mapp = [[0 for _ in range(lenb+1)] for _ in range(lena+1)]

for a in range(1,lena+1):
    for b in range(1,lenb+1):
        if A[a-1] == B[b-1]:
            mapp[a][b] = mapp[a-1][b-1] + 1
        else:
            mapp[a][b] = max(mapp[a-1][b], mapp[a][b-1])

print(mapp[lena][lenb])