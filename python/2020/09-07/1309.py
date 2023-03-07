# 동물원

# f(x,y) > 경우의 수
# f(1,y) = f(0,y-1) + f(2,y-1)
# f(0,y) = f(1,y-1) + f(2,y-1)
# f(2,y) = f(1,y-1) + f(0,y-1) + f(2,y-1)

n = int(input())
memoization = [[0, 0, 0] for _ in range(n+1)]
mod = 9901

memoization[1][0] = 1
memoization[1][1] = 1
memoization[1][2] = 1

for i in range(2,n+1):
    memoization[i][1] = (memoization[i-1][0]+memoization[i-1][2])%mod
    memoization[i][0] = (memoization[i-1][1]+memoization[i-1][2])%mod
    memoization[i][2] = (memoization[i-1][1]+memoization[i-1][0]+memoization[i-1][2])%mod

print((memoization[n][1]+memoization[n][0]+memoization[n][2])%mod)

