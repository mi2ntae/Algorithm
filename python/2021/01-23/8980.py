# 택배

import sys
input = sys.stdin.readline

N,C = map(int, input().strip().split())
M = int(input().strip())

delivery = [C for _ in range(N+1)]
dell = []
for _ in range(M):
    s,d,v = map(int, input().strip().split())
    dell.append([d,s,v])

dell.sort()

ans = 0

for i in range(M):
    d,s,v = dell[i]
    minv = 10001
    for j in range(s,d):
        if minv >= delivery[j]:
            minv = delivery[j]

    if minv >= v:
        ans += v
        for k in range(s,d):
            delivery[k] -= v
    else:
        ans += minv
        for k in range(s,d):
            delivery[k] -= minv

print(ans)