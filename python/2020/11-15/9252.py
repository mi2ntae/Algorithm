# LCS2

import sys
input = sys.stdin.readline

A = input().strip()
B = input().strip()
lena = len(A)
lenb = len(B)
mapp = [[[(0,0), 0] for _ in range(lenb+1)] for _ in range(lena+1)]

for a in range(1,lena+1):
    for b in range(1,lenb+1):
        if A[a-1] == B[b-1]:
            mapp[a][b][1] = mapp[a-1][b-1][1] + 1
            mapp[a][b][0] = (-1,-1)
        elif mapp[a-1][b][1] >= mapp[a][b-1][1]:
            mapp[a][b][1] = mapp[a-1][b][1]
            mapp[a][b][0] = (-1,0)
        else:
            mapp[a][b][1] = mapp[a][b-1][1]
            mapp[a][b][0] = (0,-1)

curr = lena
curc = lenb
ans = []

while curr > 0 and curc > 0:
    if mapp[curr][curc][0] == (-1,-1):
        ans.append(A[curr-1])
        curr -= 1
        curc -= 1
    elif mapp[curr][curc][0] == (0,-1):
        curc -= 1
    else:
        curr -= 1

ans.reverse()
print(mapp[lena][lenb][1])
print("".join(ans))