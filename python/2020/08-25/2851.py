# (100과 가장 가까운 수)

def val(num):
    if num < 0:
        num = -num
    return num


a = []
score = 0

for _ in range(10):
    get = input()
    a += [get]

aa = []
score = 0
for k in range(len(a)):
    score += int(a[k])
    aa += [score]

dd = 100
result = 0
for l in range(len(aa)):
    g = 100-aa[l]

    if dd >= val(g):
        dd = val(g)
        result = aa[l]

print(result)

# nums = [int(input()) for range(10)]
# acc = [0]
# for num in nums:
#     acc += [acc[-1] + num]

# ans = 0
# delta = 100
# for v in acc:
#     if delta >= abs(v-100):
#         delta = abs(v-100)
#         ans = v
# print(v)