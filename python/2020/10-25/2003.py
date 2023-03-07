# 수들의 합 2 (two pointer)

N, M = map(int, input().split())
A = list(map(int, input().split())) + [0]
ans = 0
head, tail = 0, 0
sumv = A[0]
while head < N:
    if sumv < M:
        head += 1
        sumv += A[head]
    elif sumv == M:
        ans += 1
        sumv -= A[tail]
        head += 1
        tail += 1
        sumv += A[head]
    else:
        sumv -= A[tail]
        tail += 1
print(ans)

