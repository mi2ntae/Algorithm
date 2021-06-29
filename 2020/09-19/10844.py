# 쉬운 계단 수

# 구해야 하는 수가 너무 크기 때문에 DP를 예상해야함
# f(N) = 맨 위의 수가 d이고, N길이의 계단수의 경우의 수
# >> f(N, 1) + f(N, 2) + ......f(N, 9)  >>  최종 정답
# f(N, d) = f(N-1, d-1) + f(N-1,d+1)   (d가 0, 9가 아닌 경우)

import sys
sys.setrecursionlimit(200)

N = int(input())

memoization = [[-1 for _ in range(10)] for _ in range(101)]

def DP(n, d):
    if n == 1:
        return 1
    if memoization[n][d] != -1:
        return memoization[n][d]

    if d == 0:
        memoization[n][d] = DP(n-1, d+1)
    elif d == 9:
        memoization[n][d] = DP(n-1, d-1)
    else:
        memoization[n][d] = DP(n-1,d-1) + DP(n-1,d+1)

    memoization[n][d] %= 1000000000

    return memoization[n][d]

res = 0
for d in range(1,10):
    res += DP(N, d)

print(res%1000000000)
