# 내려가기 (sliding window)

N = int(input())
nums = [[0 for _ in range(3)] for _ in range(2)]
memoization = [[[0 for _ in range(3)] for _ in range(2)] for _ in range(2)]

for i, v in enumerate(map(int, input().split())):
    nums[0][i] = v

for i in range(3):
    memoization[0][0][i] = nums[0][i]
    memoization[1][0][i] = nums[0][i]

for i in range(1, N):
    cur = i%2
    prev = (i-1)%2
    for i, v in enumerate(map(int, input().split())):
        nums[cur][i] = v

    memoization[0][cur][0] = max(memoization[0][prev][0], memoization[0][prev][1]) + nums[cur][0]
    memoization[0][cur][1] = max(memoization[0][prev][0], memoization[0][prev][1], memoization[0][prev][2]) + nums[cur][1]
    memoization[0][cur][2] = max(memoization[0][prev][1], memoization[0][prev][2]) + nums[cur][2]
    memoization[1][cur][0] = min(memoization[1][prev][0], memoization[1][prev][1]) + nums[cur][0]
    memoization[1][cur][1] = min(memoization[1][prev][0], memoization[1][prev][1], memoization[1][prev][2]) + nums[cur][1]
    memoization[1][cur][2] = min(memoization[1][prev][1], memoization[1][prev][2]) + nums[cur][2]
    

print(max(memoization[0][(N-1)%2]), min(memoization[1][(N-1)%2]))