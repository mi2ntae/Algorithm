# 선분 그룹

import sys
input = sys.stdin.readline
sys.setrecursionlimit(3001)

N = int(input())
lines = [list(map(int, input().split())) for _ in range(N)]
tree = [i for i in range(N)]
group = N
members = [1 for _ in range(N)]

def uFind(k):
    if tree[k] == k:
        return k
    
    tree[k] = uFind(tree[k])
    return tree[k]

def uMerge(a,b):
    global group
    a = uFind(a)
    b = uFind(b)
    if a == b:
        return
    
    group -= 1
    if members[b] > members[a]:
        a,b = b,a
    members[a] += members[b]
    tree[b] = a

def isMeet(x1,y1,x2,y2,x3,y3,x4,y4):
    s1 = x1*y2 + x2*y3 + x3*y1 - y1*x2 - y2*x3 - y3*x1
    s2 = x1*y2 + x2*y4 + x4*y1 - y1*x2 - y2*x4 - y4*x1
    s3 = x3*y4 + x4*y1 + x1*y3 - y3*x4 - y4*x1 - y1*x3
    s4 = x3*y4 + x4*y2 + x2*y3 - y3*x4 - y4*x2 - y2*x3

    if s1 * s2 <= 0 and s3 * s4 < 0:
        return True
    elif s1 * s2 < 0 and s3 * s4 <= 0:
        return True
    elif s1 * s2 == 0 and s3 * s4 == 0 and \
        ((min(x1, x2) <= x3 and x3 <= max(x1, x2)) or \
        (min(x1, x2) <= x4 and x4 <= max(x1, x2))):
        return True
    else:
        return False

for i in range(N-1):
    for k in range(i+1,N):
        if isMeet(lines[i][0], lines[i][1], lines[i][2], lines[i][3], \
            lines[k][0], lines[k][1], lines[k][2], lines[k][3]):
            uMerge(i,k)

print(group)
print(max(members))