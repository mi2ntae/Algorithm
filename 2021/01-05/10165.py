# 버스 노선

import sys
input = sys.stdin.readline

N = int(input().strip())
M = int(input().strip())
lines = [list(map(int, input().strip().split())) for _ in range(M)]
stretch = []
isokay = [True for _ in range(M+1)]
isokay[0] = False

for i,v in enumerate(lines):
    if v[0] > v[1]:
        stretch.append((v[0],v[1]+N,i+1))
    else:
        stretch.append((v[0],v[1],i+1))
        stretch.append((v[0]+N, v[1]+N, i+1))

stretch.sort(key=lambda line: (line[0], -line[1]))

end = 0
for (a,b,i) in stretch:
    if b <= end:
        isokay[i] = False
    end = max(end, b)

ans = []
for i,v in enumerate(isokay):
    if v:
        ans.append(i)

print(" ".join(map(str, ans)))
# import sys
# input = sys.stdin.readline

# N = int(input())
# M = int(input())
# lines = [tuple(map(int, input().strip().split())) for _ in range(M)]
# stretcheds = []

# for i, (b, e) in enumerate(lines):
#     if b < e:
#         stretcheds.append((i+1, b, e))
#         stretcheds.append((i+1, b + N, e + N))
#     else:
#         stretcheds.append((i+1, b, e + N))

# stretcheds.sort(key=lambda line: (line[1], -line[2]))

# deleted = set()
# most_far = 0
# for i, b, e in stretcheds:
#     if e <= most_far:
#         deleted.add(i)
#     most_far = max(most_far, e)

# ans = []
# for i in range(1, M+1):
#     if i not in deleted:
#         ans.append(i)

# print(*ans)