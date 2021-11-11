# 통나무 건너뛰기

from collections import deque
import sys
input = sys.stdin.readline

T = int(input().strip())
for _ in range(T):
    q = deque()
    N = int(input().strip())
    height = list(map(int, input().strip().split()))
    height.sort(reverse=True)

    left = True
    for i in height:
        if left:
            q.appendleft(i)
            left = False
        else:
            q.append(i)
            left = True
    
    bef = q[-1]
    ans = 0
    for i in q:
        ans = max(ans, abs(i-bef))
        bef = i
    
    print(ans)