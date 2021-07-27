# 부분합 (two pointer)

N,S = map(int, input().split())
nums = list(map(int, input().split())) + [0]

ans = N+1
head = 0
tail = 0
sumv = nums[0]

while head < N:
    if sumv >= S:
        ans = min(ans, head-tail+1)
        sumv -= nums[tail]
        tail += 1
    else:
        head += 1
        sumv += nums[head]

print(0 if ans == N+1 else ans)
    
