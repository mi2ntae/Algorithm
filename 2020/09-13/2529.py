# 부등호

K = int(input())
bud = input().split()

nums = [0,1,2,3,4,5,6,7,8,9]
result = []
tmp = []

high = "0"
low = "9999999999"

def abc(index, num, nums):
    if len(tmp) == K+1:
        # print(tmp)
        result.append("".join(map(str,tmp)))
        return

    if bud[index] == ">":
        for i in nums:
            rnums = nums[:]
            if num > i:
                rnums.remove(i)
                tmp.append(i)
                abc(index+1, i, rnums)
                tmp.remove(i)
    elif bud[index] == "<":
        for i in nums:
            rnums = nums[:]
            if num < i:
                rnums.remove(i)
                tmp.append(i)
                abc(index+1, i, rnums)   
                tmp.remove(i)

    return

for i in range(10):
    tmp = []
    tmp.append(i)
    nums.remove(i)
    abc(0, i, nums)
    nums.insert(i, i)

for r in result:
    if int(high) < int(r):
        high = r
    if int(low) > int(r):
        low = r

print(high)
print(low)