# 재귀 로또
k = input().split()
result = []
def lotto(nums, cur, pick, num, i):
    # if pick > 6:
    #     return
    if pick == 6:
        result.append(cur)
        return
    if i >= num:
        return
    cur += [nums[i]]
    lotto(nums, cur, pick+1, num, i+1)
    cur.pop()
    lotto(nums, cur, pick, num, i+1)

while int(k[0]) != 0: 
    aa = int(k[0])
    #del k[0]
    #a = " ".join(k)
    lotto(k, [], 0, aa, 0)
    result.append("")
    k = input().split()

for i in result:
    i = " ".join(i)
    print(i)



    
