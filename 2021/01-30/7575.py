# 바이러스

import sys
input = sys.stdin.readline

N,K = map(int, input().strip().split())
codes = []

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

for _ in range(N):
    a = int(input().strip())
    code = list(map(int, input().strip().split()))
    codes.append(code)

ans = False

for g in range(len(codes[0])-K+1):
    code = codes[0][g:g+K]
    ff = build_failure(code)
    isin = True

    for sub in codes[1:]:
        flag = False
        k = 0
        for i in range(len(sub)):
            while k != 0 and sub[i] != code[k]:
                k = ff[k-1]

            if sub[i] == code[k]:
                k += 1

            if k == len(code):
                flag = True
                break

        k = 0
        for i in range(len(sub)-1, -1, -1):
            while k != 0 and sub[i] != code[k]:
                k = ff[k-1]

            if sub[i] == code[k]:
                k += 1

            if k == len(code):
                flag = True
                break

        if not flag:
            isin = False
            break
    
    if isin:
        ans = True

print("YES" if ans else "NO")