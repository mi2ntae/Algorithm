# 히스토그램에서 가장 큰 직사각형

import sys
input = sys.stdin.readline

while True:
    a = list(map(int, input().strip().split()))
    if a[0] == 0:
        break

    ans = 0
    rect = a[1:]+[0]
    stack = []
    idx = 0
    for i in rect:
        if stack:
            if stack[-1][0] <= i:
                stack.append([i,idx])
                idx += 1
            else:
                d = 0
                while stack and stack[-1][0] > i:
                    k = stack.pop()
                    d = k[1]
                    ans = max(ans, k[0]*(idx-k[1]))
                stack.append([i,d])
                idx += 1
        else:
            stack.append([i,idx])
            idx += 1
    print(ans)