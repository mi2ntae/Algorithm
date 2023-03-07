# 소수 구하기 (에라토스테네스의 체)
input = input().split()

m = int(input[0])
n = int(input[1])

nums = [True]*(n+1)
nums[0] = False
nums[1] = False

for i in range(2,len(nums)):
    if nums[i]:
        for k in range(2,(n//i)+1):
            nums[i*k] = False

idx = 0
for p in nums:
    if idx >= m:
        if p:
            print(idx)
    idx += 1


    