# 동전1

n,k = input().split()
n = int(n)
k = int(k)
coin = [int(input()) for _ in range(n)]

cache = [0] * (k+1)
cache[0] = 1

for c in coin:
    for amount in range(k):
        if amount+c > k:
            continue
        cache[amount + c] += cache[amount]
    print(cache)

print(cache[k])
# for i in range(1,k):
    # for c in coin:
    #     if i-c < 0:
    #         continue
    #     cache[i] += cache[i-c]


