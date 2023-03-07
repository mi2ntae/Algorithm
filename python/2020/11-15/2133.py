# 타일 채우기

N = int(input())

memoization = [-1 for _ in range(N+1)]
memoization[0] = 1
memoization[1] = 0

# def Dp(n):
#     if memoization[n] != -1:
#         return memoization[n]

#     memoization[n] = Dp(n-2) * 3
#     idx = 4
#     while n - idx >= 0:
#         memoization[n] += Dp(n-idx) * 2
#         idx += 2

#     return memoization[n]

# print(Dp(N))

for i in range(2,N+1):
    memoization[i] = memoization[i-2] * 3
    idx = 4
    while i - idx >= 0:
        memoization[i] += memoization[i-idx] * 2
        idx += 2

print(memoization[N])