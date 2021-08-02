# 합이 0인 네 정수
import sys
input = sys.stdin.readline

N = int(input().strip())

A = []
B = []
C = []
D = []
ab = []
cd = []

for _ in range(N):
    a,b,c,d = map(int, input().strip().split())
    A.append(a)
    B.append(b)
    C.append(c)
    D.append(d)

for m in range(N):
    for n in range(N):
        ab.append(A[m]+B[n])
        cd.append(C[m]+D[n])

ab.sort()
cd.sort()

ab_p = 0
cd_p = len(cd)-1
ans = 0
NN = N*N
while ab_p < NN and cd_p >= 0:
    ret = ab[ab_p] + cd[cd_p]
    if ret == 0:
        
    elif ret < 0:
        ab_p += 1
    else:
        cd_p -= 1

print(ans)