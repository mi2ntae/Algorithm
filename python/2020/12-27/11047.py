# 동전 0

N,K = map(int, input().split())
coin = [int(input()) for _ in range(N)]
ans = 0
for i in range(N-1,-1,-1):
    ans += K//coin[i]
    K %= coin[i]

print(ans)