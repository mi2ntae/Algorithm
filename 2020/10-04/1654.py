# 랜선 자르기
import sys
input = sys.stdin.readline

K, N = map(int, input().split())
lines = [int(input()) for _ in range(K)]

beg = 0
end = max(lines) + 1

while end - beg > 1:
    n = 0
    mid = (beg + end) // 2
    for line in lines:
        n += line//mid
        if n == N:
            break 
    if n >= N:
        beg = mid
    else:
        end = mid

print(beg)