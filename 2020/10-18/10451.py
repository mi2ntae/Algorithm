# 순열 사이클
import sys
input = sys.stdin.readline

T = int(input())

for _ in range(T):
    N = int(input())
    nums = list(map(int, input().split()))
    isin = [False for _ in range(N+1)]
    isin[0] = True
    count = 0

    for i in range(N):
        if not isin[i+1] and not isin[nums[i]]:
            count += 1 
        isin[i+1] = True
        isin[nums[i]] = True

    print(count)