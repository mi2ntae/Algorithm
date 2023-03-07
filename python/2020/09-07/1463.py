# 1로 만들기

# import sys
# sys.setrecursionlimit(10000000)

# N = int(input())
# memoization = [N+1 for _ in range(N+1)]
# memoization[1] = 0

# def make(n):
#     if n < 1:
#         return N+1

#     if memoization[n] != N+1:
#         return memoization[n]

#     a = -1
#     b = -1
#     if n%3 == 0:
#         a = n//3
#     if n%2 == 0:
#         b = n//2

#     memoization[n] = int(min(make(a), make(b), make(n-1))) + 1
#     return memoization[n]

# print(make(N))

# 바텀업 : 부분문제 정의, 점화식 정의, 방향 설정하고 방향대로 진행하며 돌림
N = int(input())
memoization = [N+1 for _ in range(N+1)]
memoization[1] = 0

for i in range(2, N+1):
    if i%3 == 0:
        memoization[i] = min(memoization[i], memoization[i//3]+1)
    if i%2 == 0:
        memoization[i] = min(memoization[i], memoization[i//2]+1)
    memoization[i] = min(memoization[i], memoization[i-1]+1)

print(memoization[N])
# import sys
# sys.setrecursionlimit(10000000)

# N = int(input())
# count = N+1

# def make(n, c):
#     global count
#     if n%1 != 0 or n < 1:
#         return

#     if n == 1:
#         if count >= c:
#             count = c
#         return
#     n = int(n)
#     c += 1

#     make(n/3, c)
#     make(n/2, c)
#     make(n-1, c)
#     return

# make(N, 0)
# print(count)