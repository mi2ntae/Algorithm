# 찾기

import sys
input = sys.stdin.readline

def build_failure(S):
    ff = [0 for _ in range(len(S))]
    
    for cur in range(1,len(S)):
        bef = ff[cur-1]
        
        while bef != 0 and S[cur] != S[bef]:
            bef = ff[bef-1]

        if S[cur] == S[bef]:
            ff[cur] = bef + 1
        else:
            ff[cur] = 0
    
    return ff
T = input()[:-1]
P = input()[:-1]

ff = build_failure(P)

ans = []
k = 0
for i in range(len(T)):
    while k != 0 and T[i] != P[k]:
        k = ff[k-1]

    if T[i] == P[k]:
        k += 1

    if k == len(P):
        ans.append(i-len(P)+2)
        k = ff[k-1]

print(len(ans))
print(*ans)